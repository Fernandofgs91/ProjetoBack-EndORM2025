package com.exercicio.exercicio.controller;

import com.exercicio.exercicio.dto.MediaDTO;
import com.exercicio.exercicio.dto.MatrizDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matematica")
public class MatematicaController {

    @GetMapping("/soma")
    public ResponseEntity<?> somar(@RequestParam(required = true) Double a,
                                   @RequestParam(required = true) Double b) {
        double resultado = a + b;
        return ResponseEntity.ok().body(new ResultadoDTO(resultado));
    }

    @GetMapping("/fatorial")
    public ResponseEntity<?> fatorial(@RequestParam(required = true) Integer n) {
        if (n < 0) {
            throw new RuntimeException("Número não pode ser negativo.");
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return ResponseEntity.ok().body(new ResultadoDTO(resultado));
    }

    @PostMapping("/media")
    public ResponseEntity<?> media(@RequestBody @Valid MediaDTO mediaDTO) {
        List<Double> valores = mediaDTO.getValores();
        if (valores.isEmpty()) {
            throw new RuntimeException("Lista de valores não pode ser vazia.");
        }
        double media = valores.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        return ResponseEntity.ok().body(new ResultadoDTO(media));
    }

    @PostMapping("/soma-linhas")
    public ResponseEntity<?> somaLinhas(@RequestBody @Valid MatrizDTO matrizDTO) {
        List<List<Integer>> matriz = matrizDTO.getMatriz();
        if (matriz.isEmpty() || matriz.stream().anyMatch(linha -> linha.size() != matriz.get(0).size())) {
            throw new RuntimeException("Matriz inválida.");
        }

        List<Integer> somas = matriz.stream()
            .map(linha -> linha.stream().mapToInt(Integer::intValue).sum())
            .toList();
        
        return ResponseEntity.ok().body(new ResultadoListaDTO(somas));
    }

    // DTO interno para respostas
    record ResultadoDTO(Number resultado) {}
    record ResultadoListaDTO(List<Integer> resultado) {}
}