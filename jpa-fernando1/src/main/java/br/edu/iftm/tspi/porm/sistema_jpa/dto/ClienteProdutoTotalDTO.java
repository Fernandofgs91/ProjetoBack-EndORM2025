package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ClienteProdutoTotalDTO {
    private Integer produtoId;
    private String produtoNome;
    private Double totalConsumido;

    public ClienteProdutoTotalDTO(Integer produtoId, String produtoNome, Double totalConsumido) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.totalConsumido = totalConsumido;
    }

    // Getters and Setters
}