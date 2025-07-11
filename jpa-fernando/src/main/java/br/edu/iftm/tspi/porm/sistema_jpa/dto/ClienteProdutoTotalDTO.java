package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ClienteProdutoTotalDTO {
    private Long produtoId;
    private String produtoNome;
    private Double totalConsumido;

    public ClienteProdutoTotalDTO(Long produtoId, String produtoNome, Double totalConsumido) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.totalConsumido = totalConsumido;
    }

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
    public String getProdutoNome() { return produtoNome; }
    public void setProdutoNome(String produtoNome) { this.produtoNome = produtoNome; }
    public Double getTotalConsumido() { return totalConsumido; }
    public void setTotalConsumido(Double totalConsumido) { this.totalConsumido = totalConsumido; }
}
