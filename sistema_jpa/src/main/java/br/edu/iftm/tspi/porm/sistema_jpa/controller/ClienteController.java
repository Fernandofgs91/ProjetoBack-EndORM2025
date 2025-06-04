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

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ClienteDto;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.ClienteMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteController(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        List<Cliente> clientes = repository.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mapper.toDtoList(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarPorId(@PathVariable String id) {
        Cliente cliente = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cliente com id " + id + " não encontrado"));
        return ResponseEntity.ok(mapper.toDto(cliente));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> criar(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente clienteSalvo = repository.save(mapper.toEntity(clienteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(clienteSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(@PathVariable String id, @Valid @RequestBody ClienteDto dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Cliente com id " + id + " não encontrado");
        }
        dto.setId(id);
        Cliente clienteAtualizado = repository.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(clienteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        return repository.findById(id)
            .map(cliente -> {
                repository.delete(cliente);
                return ResponseEntity.noContent().build();
            })
            .orElseThrow(() -> new EntityNotFoundException("Cliente com id " + id + " não encontrado"));
    }
}
