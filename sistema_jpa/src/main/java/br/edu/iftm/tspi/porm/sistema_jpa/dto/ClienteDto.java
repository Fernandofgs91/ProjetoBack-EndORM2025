package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private String id;
    private String nome;
    private String cargo;
    private String endereco;
    private String cep;
    private String pais;
    private String telefone;
    private String fax;
}
