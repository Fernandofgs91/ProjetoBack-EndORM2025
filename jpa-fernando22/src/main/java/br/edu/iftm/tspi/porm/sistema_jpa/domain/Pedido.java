package br.edu.iftm.tspi.porm.sistema_jpa.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PedidoID")
    private Integer id;

    @Column(name="datapedido")
    private LocalDateTime dataPedido;

    @ManyToOne
    @JoinColumn(name="ClienteID", nullable=false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(mappedBy="pedido", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<DetalhePedido> detalhesPedido;

    // Método para facilitar a atribuição de detalhes ao pedido
    public void addDetalhe(DetalhePedido detalhe) {
        if (detalhesPedido == null) {
            detalhesPedido = new java.util.ArrayList<>();
        }
        detalhesPedido.add(detalhe);
        detalhe.setPedido(this);
    }
}