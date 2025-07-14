package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;

@Mapper(componentModel = "spring",
        uses = {DetalhePedidoMapper.class, ClienteMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PedidoMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "cliente.nome", target = "clienteNome")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "detalhesPedido", target = "detalhesPedido")
    PedidoDto toDto(Pedido entity);

    @Mapping(source = "clienteId", target = "cliente.id")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "detalhesPedido", target = "detalhesPedido")
    Pedido toEntity(PedidoDto dto);

    List<PedidoDto> toDtoList(List<Pedido> entities);

    List<Pedido> toEntityList(List<PedidoDto> dtos);

    @Mapping(target = "id", ignore = true) // Nunca atualize o ID da entidade
    @Mapping(target = "cliente", ignore = true) // Cliente não deve ser atualizado a partir do DTO
    @Mapping(target = "dataPedido", ignore = true) // Data do pedido não deve ser alterada
    @Mapping(target = "detalhesPedido", ignore = true) // Evita atualizar lista de detalhes, a não ser que você deseje isso
    void updateFromDto(PedidoDto dto, @MappingTarget Pedido entity);
}
