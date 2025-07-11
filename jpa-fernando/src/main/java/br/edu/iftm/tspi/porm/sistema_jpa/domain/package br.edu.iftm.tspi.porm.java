package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import br.edu.iftm.tspi.porm.sistema_jpa.dto.ClienteProdutoTotalDTO;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ProdutoPedidoDTO;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedidoId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, DetalhePedidoId> {

    @Query("SELECT new br.edu.iftm.tspi.porm.sistema_jpa.dto.ProdutoPedidoDTO(p.pedido.id, p.produto.codigo, SUM(p.quantidade), SUM(p.quantidade * p.precoVenda), SUM(p.desconto)) " +
           "FROM DetalhePedido p WHERE p.produto.codigo = :produtoId GROUP BY p.pedido.id, p.produto.codigo")
    List<ProdutoPedidoDTO> buscarPorProduto(@Param("produtoId") Long produtoId);

    @Query("SELECT new br.edu.iftm.tspi.porm.sistema_jpa.dto.ClienteProdutoTotalDTO(p.produto.id, p.produto.nome, SUM(p.quantidade * p.valorUnitario)) " +
           "FROM DetalhePedido p WHERE p.pedido.cliente.id = :clienteId GROUP BY p.produto.id, p.produto.nome")
    List<ClienteProdutoTotalDTO> buscarTotalPorProdutoCliente(@Param("clienteId") Long clienteId);

    @Query("SELECT SUM(p.quantidade * p.valorUnitario) FROM DetalhePedido p WHERE p.produto.categoria.id = :categoriaId")
    Double buscarTotalPorCategoria(@Param("categoriaId") Long categoriaId);

    @Query("SELECT p FROM DetalhePedido p WHERE p.pedido.cliente.id = :clienteId AND p.pedido.dataPedido BETWEEN :dataInicio AND :dataFim")
    List<DetalhePedido> buscarPedidosPorClienteEPeriodo(@Param("clienteId") Long clienteId,
                                                        @Param("dataInicio") Date dataInicio,
                                                        @Param("dataFim") Date dataFim);
}
