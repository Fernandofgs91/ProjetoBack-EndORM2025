package br.edu.iftm.tspi.porm.sistema_jpa.dto;

public class ClienteProdutoTotalDTO {
    private Integer produtoId; // Alterado de Long para Integer
    private String produtoNome;
    private Double totalConsumido;
    // O campo clienteId foi removido do DTO pois ele é um parâmetro de entrada da query, não um campo do DTO retornado.
    // Se a query retornasse o clienteId, ele deveria estar aqui.

    public ClienteProdutoTotalDTO(Integer produtoId, String produtoNome, Double totalConsumido) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.totalConsumido = totalConsumido;
    }

    public Integer getProdutoId() { return produtoId; }
    public void setProdutoId(Integer produtoId) { this.produtoId = produtoId; }
    public String getProdutoNome() { return produtoNome; }
    public void setProdutoNome(String produtoNome) { this.produtoNome = produtoNome; }
    public Double getTotalConsumido() { return totalConsumido; }
    public void setTotalConsumido(Double totalConsumido) { this.totalConsumido = totalConsumido; }
}