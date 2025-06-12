package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalhePedidoDto {
    @NotNull(message = "O campo pedidoId não pode ser nulo")
    private Integer pedidoId;
    @NotNull(message = "O campo produtoId não pode ser nulo")
    private Integer produtoId;
    private Double precoVenda;
    private Short quantidade;
    private Double desconto;
}
