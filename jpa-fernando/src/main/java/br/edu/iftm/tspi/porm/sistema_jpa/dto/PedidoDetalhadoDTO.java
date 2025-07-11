package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import java.util.List;

public class PedidoDetalhadoDTO {
    private Long numeroPedido;
    private List<ProdutoPedidoDTO> produtos;
    private Double valorTotalPedido;

    public PedidoDetalhadoDTO(Long numeroPedido, List<ProdutoPedidoDTO> produtos, Double valorTotalPedido) {
        this.numeroPedido = numeroPedido;
        this.produtos = produtos;
        this.valorTotalPedido = valorTotalPedido;
    }

    public Long getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Long numeroPedido) { this.numeroPedido = numeroPedido; }
    public List<ProdutoPedidoDTO> getProdutos() { return produtos; }
    public void setProdutos(List<ProdutoPedidoDTO> produtos) { this.produtos = produtos; }
    public Double getValorTotalPedido() { return valorTotalPedido; }
    public void setValorTotalPedido(Double valorTotalPedido) { this.valorTotalPedido = valorTotalPedido; }
}
