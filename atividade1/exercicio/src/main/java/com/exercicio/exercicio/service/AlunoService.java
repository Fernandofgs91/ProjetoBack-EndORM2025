package com.exercicio.exercicio.service;

import com.exercicio.exercicio.domain.Aluno;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();

    public Aluno criar(Aluno aluno) {
        if (alunos.stream().anyMatch(a -> a.getRa().equals(aluno.getRa()))) {
            throw new RuntimeException("Aluno já cadastrado.");
        }
        alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> listar() {
        return alunos;
    }

    public Aluno buscar(String ra) {
        return alunos.stream()
            .filter(aluno -> aluno.getRa().equals(ra))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
    }

    public Aluno atualizar(String ra, Aluno novoAluno) {
        Aluno aluno = buscar(ra);
        aluno.setNome(novoAluno.getNome());
        aluno.setEmail(novoAluno.getEmail());
        aluno.setCursoSigla(novoAluno.getCursoSigla());
        return aluno;
    }

    public void remover(String ra) {
        Aluno aluno = buscar(ra);
        alunos.remove(aluno);
    }
}