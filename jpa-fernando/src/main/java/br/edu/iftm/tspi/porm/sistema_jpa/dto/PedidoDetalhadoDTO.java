package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import java.util.List;

public class PedidoDetalhadoDTO {
    private Integer numeroPedido; // Alterado de Long para Integer
    private List<ProdutoPedidoDTO> produtos;
    private Double valorTotalPedido;

    public PedidoDetalhadoDTO(Integer numeroPedido, List<ProdutoPedidoDTO> produtos, Double valorTotalPedido) {
        this.numeroPedido = numeroPedido;
        this.produtos = produtos;
        this.valorTotalPedido = valorTotalPedido;
    }

    public Integer getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Integer numeroPedido) { this.numeroPedido = numeroPedido; }
    public List<ProdutoPedidoDTO> getProdutos() { return produtos; }
    public void setProdutos(List<ProdutoPedidoDTO> produtos) { this.produtos = produtos; }
    public Double getValorTotalPedido() { return valorTotalPedido; }
    public void setValorTotalPedido(Double valorTotalPedido) { this.valorTotalPedido = valorTotalPedido; }
}