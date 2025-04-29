package com.exercicio.exercicio.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class MediaDTO {
    @NotEmpty
    private List<Double> valores;
}