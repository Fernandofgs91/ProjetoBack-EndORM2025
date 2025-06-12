package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private Integer id;
    private LocalDateTime dataPedido;
    private String clienteId;
    private List<DetalhePedidoDto> detalhesPedido;
}
