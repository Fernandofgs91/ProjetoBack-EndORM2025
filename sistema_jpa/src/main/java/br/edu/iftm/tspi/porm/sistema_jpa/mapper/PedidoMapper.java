package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    @Mapping(source = "cliente.id", target = "clienteId")
    PedidoDto toDto(Pedido entity);
    @Mapping(source = "clienteId", target = "cliente.id")
    Pedido toEntity(PedidoDto dto);
    List<PedidoDto> toDtoList(List<Pedido> entities);
    List<Pedido> toEntityList(List<PedidoDto> dtos);
}
