package br.edu.iftm.tspi.porm.sistema_jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.PedidoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.PedidoRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final PedidoService pedidoService;

    public PedidoController(PedidoRepository repository, PedidoMapper mapper, PedidoService pedidoService) {
        this.repository = repository;
        this.mapper = mapper;
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listarTodos() {
        List<Pedido> pedidos = repository.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapper.toDtoList(pedidos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Integer id) {
        Pedido pedido = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + id + " não encontrado"));
        return ResponseEntity.ok(mapper.toDto(pedido));
    }

    @PostMapping
    public ResponseEntity<PedidoDto> criar(@Valid @RequestBody PedidoDto pedidoDto) {
        Pedido pedidoSalvo = repository.save(mapper.toEntity(pedidoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(pedidoSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Integer id, @Valid @RequestBody PedidoDto dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Pedido com id " + id + " não encontrado");
        }
        dto.setId(id);
        Pedido pedidoAtualizado = repository.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(pedidoAtualizado));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Integer id) {
        pedidoService.cancelarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return repository.findById(id)
            .map(pedido -> {
                repository.delete(pedido);
                return ResponseEntity.noContent().build();
            })
            .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + id + " não encontrado"));
    }
}