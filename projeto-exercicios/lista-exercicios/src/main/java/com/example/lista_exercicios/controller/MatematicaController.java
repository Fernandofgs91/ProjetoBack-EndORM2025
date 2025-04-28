package com.example.listaexercicios.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/matematica")
public class MatematicaController {

    @GetMapping("/soma")
    public ResponseEntity<?> somar(
            @RequestParam(name = "a", required = true) double a,
            @RequestParam(name = "b", required = true) double b) {
        return ResponseEntity.ok().body(new Resultado(a + b));
    }

    @GetMapping("/fatorial")
    public ResponseEntity<?> fatorial(
            @RequestParam(name = "n", required = true) int n) {
        if (n < 0) {
            return ResponseEntity.badRequest().body("O valor de n não pode ser negativo");
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return ResponseEntity.ok().body(new Resultado(resultado));
    }

    @PostMapping("/media")
    public ResponseEntity<?> calcularMedia(@RequestBody ValoresRequest valores) {
        if (valores.getValores() == null || valores.getValores().isEmpty()) {
            return ResponseEntity.badRequest().body("A lista de valores não pode estar vazia");
        }
        double soma = valores.getValores().stream().mapToDouble(Double::doubleValue).sum();
        return ResponseEntity.ok().body(new Resultado(soma / valores.getValores().size()));
    }

    @PostMapping("/soma-linhas")
    public ResponseEntity<?> somarLinhas(@RequestBody MatrizRequest matriz) {
        if (matriz.getMatriz() == null || matriz.getMatriz().isEmpty()) {
            return ResponseEntity.badRequest().body("A matriz não pode estar vazia");
        }
        int tamanhoLinha = matriz.getMatriz().get(0).size();
        for (List<Double> linha : matriz.getMatriz()) {
            if (linha.size() != tamanhoLinha) {
                return ResponseEntity.badRequest().body("Todas as linhas devem ter o mesmo tamanho");
            }
        }
        List<Double> somas = matriz.getMatriz().stream()
                .map(linha -> linha.stream().mapToDouble(Double::doubleValue).sum())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new Resultado(somas));
    }

    // Classes internas para request/response
    static class Resultado {
        private Object resultado;

        public Resultado(Object resultado) {
            this.resultado = resultado;
        }

        public Object getResultado() {
            return resultado;
        }
    }

    static class ValoresRequest {
        private List<Double> valores;

        public List<Double> getValores() {
            return valores;
        }

        public void setValores(List<Double> valores) {
            this.valores = valores;
        }
    }

    static class MatrizRequest {
        private List<List<Double>> matriz;

        public List<List<Double>> getMatriz() {
            return matriz;
        }

        public void setMatriz(List<List<Double>> matriz) {
            this.matriz = matriz;
        }
    }
}