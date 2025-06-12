package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;

@Mapper(componentModel = "spring")
public interface DetalhePedidoMapper {
    @Mapping(source = "id.pedidoId", target = "pedidoId")
    @Mapping(source = "id.produtoId", target = "produtoId")
    DetalhePedidoDto toDto(DetalhePedido entity);
    @Mapping(source = "pedidoId", target = "id.pedidoId")
    @Mapping(source = "produtoId", target = "id.produtoId")
    DetalhePedido toEntity(DetalhePedidoDto dto);
    List<DetalhePedidoDto> toDtoList(List<DetalhePedido> entities);
    List<DetalhePedido> toEntityList(List<DetalhePedidoDto> dtos);
}
