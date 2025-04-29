package com.exercicio.exercicio.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class MatrizDTO {
    @NotEmpty
    private List<List<Integer>> matriz;
}