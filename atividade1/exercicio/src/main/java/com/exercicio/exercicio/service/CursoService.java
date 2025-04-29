package com.exercicio.exercicio.service;

import com.exercicio.exercicio.domain.Curso;
import com.exercicio.exercicio.domain.Aluno;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CursoService {

    private final Map<String, Curso> cursos = new HashMap<>();
    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public Curso criar(Curso curso) {
        if (cursos.containsKey(curso.getSigla())) {
            throw new RuntimeException("Curso já cadastrado.");
        }
        cursos.put(curso.getSigla(), curso);
        return curso;
    }

    public List<Curso> listar() {
        return new ArrayList<>(cursos.values());
    }

    public Curso buscar(String sigla) {
        Curso curso = cursos.get(sigla);
        if (curso == null) {
            throw new RuntimeException("Curso não encontrado.");
        }
        return curso;
    }

    public Curso atualizar(String sigla, Curso novoCurso) {
        buscar(sigla);
        novoCurso.setSigla(sigla);
        cursos.put(sigla, novoCurso);
        return novoCurso;
    }

    public void remover(String sigla) {
        buscar(sigla);
        boolean alunosVinculados = alunoService.listar().stream()
            .anyMatch(aluno -> aluno.getCursoSigla().equals(sigla));
        if (alunosVinculados) {
            throw new RuntimeException("Curso possui alunos vinculados.");
        }
        cursos.remove(sigla);
    }

    public List<Aluno> listarAlunosDoCurso(String sigla) {
        buscar(sigla);
        return alunoService.listar().stream()
            .filter(aluno -> aluno.getCursoSigla().equals(sigla))
            .toList();
    }
}