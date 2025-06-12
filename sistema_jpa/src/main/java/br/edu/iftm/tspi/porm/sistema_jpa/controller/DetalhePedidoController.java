package br.edu.iftm.tspi.porm.sistema_jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedidoId;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.DetalhePedidoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.DetalhePedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/detalhes-pedido")
public class DetalhePedidoController {

    private final DetalhePedidoRepository repository;
    private final DetalhePedidoMapper mapper;

    public DetalhePedidoController(DetalhePedidoRepository repository, DetalhePedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<DetalhePedidoDto>> listarTodos() {
        List<DetalhePedido> detalhes = repository.findAll();
        if (detalhes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapper.toDtoList(detalhes));
    }

    @GetMapping("/{pedidoId}/{produtoId}")
    public ResponseEntity<DetalhePedidoDto> buscarPorId(@PathVariable Integer pedidoId, @PathVariable Integer produtoId) {
        DetalhePedidoId id = new DetalhePedidoId(pedidoId, produtoId);
        DetalhePedido detalhe = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("DetalhePedido não encontrado para pedidoId=" + pedidoId + " e produtoId=" + produtoId));
        return ResponseEntity.ok(mapper.toDto(detalhe));
    }

    @PostMapping
    public ResponseEntity<DetalhePedidoDto> criar(@Valid @RequestBody DetalhePedidoDto dto) {
        DetalhePedido detalheSalvo = repository.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(detalheSalvo));
    }

    @PutMapping("/{pedidoId}/{produtoId}")
    public ResponseEntity<DetalhePedidoDto> atualizar(@PathVariable Integer pedidoId, @PathVariable Integer produtoId, @Valid @RequestBody DetalhePedidoDto dto) {
        DetalhePedidoId id = new DetalhePedidoId(pedidoId, produtoId);
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("DetalhePedido não encontrado para pedidoId=" + pedidoId + " e produtoId=" + produtoId);
        }
        dto.setPedidoId(pedidoId);
        dto.setProdutoId(produtoId);
        DetalhePedido detalheAtualizado = repository.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(detalheAtualizado));
    }

    @DeleteMapping("/{pedidoId}/{produtoId}")
    public ResponseEntity<?> deletar(@PathVariable Integer pedidoId, @PathVariable Integer produtoId) {
        DetalhePedidoId id = new DetalhePedidoId(pedidoId, produtoId);
        return repository.findById(id)
            .map(detalhe -> {
                repository.delete(detalhe);
                return ResponseEntity.noContent().build();
            })
            .orElseThrow(() -> new EntityNotFoundException("DetalhePedido não encontrado para pedidoId=" + pedidoId + " e produtoId=" + produtoId));
    }
}
