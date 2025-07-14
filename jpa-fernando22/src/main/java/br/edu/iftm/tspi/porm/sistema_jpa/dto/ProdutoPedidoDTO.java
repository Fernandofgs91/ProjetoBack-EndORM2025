package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ProdutoPedidoDTO {
    private Integer numeroPedido;
    private Integer produtoId;
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

    // Getters and Setters
}