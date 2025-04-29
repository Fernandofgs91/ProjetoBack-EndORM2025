package com.exercicio.exercicio.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @NotBlank
    @Size(min = 2, max = 10)
    private String sigla;

    @NotBlank
    private String nome;

    private String descricao;
}
