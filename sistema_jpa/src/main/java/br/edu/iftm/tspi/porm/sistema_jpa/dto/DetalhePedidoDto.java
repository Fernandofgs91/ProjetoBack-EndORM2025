package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalhePedidoDto {
    private Integer pedidoId;
    private Integer produtoId;
    private Double precoVenda;
    private Short quantidade;
    private Double desconto;
}
