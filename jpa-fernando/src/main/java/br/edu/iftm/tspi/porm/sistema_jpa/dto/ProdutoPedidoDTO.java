package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ProdutoPedidoDTO {
    private Integer numeroPedido; // Alterado de Long para Integer
    private Integer produtoId;    // Alterado de Long para Integer
    private Long quantidadeVendida;
    private Double valorTotalProduto;
    private Double valorTotalDesconto;

    public ProdutoPedidoDTO(Integer numeroPedido, Integer produtoId, Long quantidadeVendida, Double valorTotalProduto, Double valorTotalDesconto) {
        this.numeroPedido = numeroPedido;
        this.produtoId = produtoId;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotalProduto = valorTotalProduto;
        this.valorTotalDesconto = valorTotalDesconto;
    }

    public Integer getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Integer numeroPedido) { this.numeroPedido = numeroPedido; }
    public Integer getProdutoId() { return produtoId; }
    public void setProdutoId(Integer produtoId) { this.produtoId = produtoId; }
    public Long getQuantidadeVendida() { return quantidadeVendida; }
    public void setQuantidadeVendida(Long quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }
    public Double getValorTotalProduto() { return valorTotalProduto; }
    public void setValorTotalProduto(Double valorTotalProduto) { this.valorTotalProduto = valorTotalProduto; }
    public Double getValorTotalDesconto() { return valorTotalDesconto; }
    public void setValorTotalDesconto(Double valorTotalDesconto) { this.valorTotalDesconto = valorTotalDesconto; }
}