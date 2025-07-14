package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import java.util.List;

public class PedidoDetalhadoDTO {
    private Integer numeroPedido;
    private List<ProdutoPedidoDTO> produtos;
    private Double valorTotalPedido;

    public PedidoDetalhadoDTO(Integer numeroPedido, List<ProdutoPedidoDTO> produtos, Double valorTotalPedido) {
        this.numeroPedido = numeroPedido;
        this.produtos = produtos;
        this.valorTotalPedido = valorTotalPedido;
    }
    // Getters and Setters
}