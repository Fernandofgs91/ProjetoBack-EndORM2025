package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ProdutoPedidoDTO {
    private Long numeroPedido;
    private Long produtoId;
    private Integer quantidadeVendida;
    private Double valorTotalProduto;
    private Double valorTotalDesconto;

    public ProdutoPedidoDTO(Long numeroPedido, Long produtoId, Integer quantidadeVendida, Double valorTotalProduto, Double valorTotalDesconto) {
        this.numeroPedido = numeroPedido;
        this.produtoId = produtoId;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotalProduto = valorTotalProduto;
        this.valorTotalDesconto = valorTotalDesconto;
    }

    public Long getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Long numeroPedido) { this.numeroPedido = numeroPedido; }
    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
    public Integer getQuantidadeVendida() { return quantidadeVendida; }
    public void setQuantidadeVendida(Integer quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }
    public Double getValorTotalProduto() { return valorTotalProduto; }
    public void setValorTotalProduto(Double valorTotalProduto) { this.valorTotalProduto = valorTotalProduto; }
    public Double getValorTotalDesconto() { return valorTotalDesconto; }
    public void setValorTotalDesconto(Double valorTotalDesconto) { this.valorTotalDesconto = valorTotalDesconto; }
}
