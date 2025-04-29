package com.exercicio.exercicio.controller;

import com.exercicio.exercicio.domain.Curso;
import com.exercicio.exercicio.domain.Aluno;
import com.exercicio.exercicio.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody @Valid Curso curso) {
        return ResponseEntity.status(201).body(cursoService.criar(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<Curso> buscar(@PathVariable String sigla) {
        return ResponseEntity.ok(cursoService.buscar(sigla));
    }

    @PutMapping("/{sigla}")
    public ResponseEntity<Curso> atualizar(@PathVariable String sigla, @RequestBody @Valid Curso curso) {
        return ResponseEntity.ok(cursoService.atualizar(sigla, curso));
    }

    @DeleteMapping("/{sigla}")
    public ResponseEntity<Void> remover(@PathVariable String sigla) {
        cursoService.remover(sigla);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{sigla}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunos(@PathVariable String sigla) {
        return ResponseEntity.ok(cursoService.listarAlunosDoCurso(sigla));
    }
}