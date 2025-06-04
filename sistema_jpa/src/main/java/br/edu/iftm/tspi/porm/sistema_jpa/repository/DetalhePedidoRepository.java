package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedidoId;

public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, DetalhePedidoId> {
    // Métodos customizados podem ser adicionados aqui
}
