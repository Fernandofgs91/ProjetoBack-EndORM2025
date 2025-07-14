package br.edu.iftm.tspi.porm.sistema_jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Produto;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.StatusPedido;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.PedidoRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    // Supondo um serviço de pagamento para estorno
    // private final PagamentoService pagamentoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository /*, PagamentoService pagamentoService */) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        // this.pagamentoService = pagamentoService;
    }

    @Transactional
    public void cancelarPedido(Integer pedidoId) {
        // 1. Busca pedido
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + pedidoId + " não encontrado."));

        // 2. Valida se pode cancelar
        if (pedido.getStatus() == StatusPedido.CANCELADO || pedido.getStatus() == StatusPedido.ENVIADO) {
            throw new IllegalStateException("O pedido não pode ser cancelado pois já foi " + pedido.getStatus().toString().toLowerCase() + ".");
        }

        // 3. Estorna o pagamento (lógica de integração com gateway de pagamento)
        // pagamentoService.estornar(pedido.getPagamentoId());
        System.out.println("Pagamento do pedido " + pedidoId + " estornado (simulação).");


        // 4. Devolve itens ao estoque
        for (DetalhePedido detalhe : pedido.getDetalhesPedido()) {
            Produto produto = detalhe.getProduto();
            int novaQuantidade = produto.getEstoque() + detalhe.getQuantidade();
            produto.setEstoque((short) novaQuantidade);
            produtoRepository.save(produto);
        }

        // 5. Marca pedido como CANCELADO
        pedido.setStatus(StatusPedido.CANCELADO);
        pedidoRepository.save(pedido);
    }
}