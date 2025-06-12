package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedidoId;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-11T20:06:45-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class DetalhePedidoMapperImpl implements DetalhePedidoMapper {

    @Override
    public DetalhePedidoDto toDto(DetalhePedido entity) {
        if ( entity == null ) {
            return null;
        }

        DetalhePedidoDto.DetalhePedidoDtoBuilder detalhePedidoDto = DetalhePedidoDto.builder();

        detalhePedidoDto.pedidoId( entityIdPedidoId( entity ) );
        detalhePedidoDto.produtoId( entityIdProdutoId( entity ) );
        detalhePedidoDto.desconto( entity.getDesconto() );
        detalhePedidoDto.precoVenda( entity.getPrecoVenda() );
        detalhePedidoDto.quantidade( entity.getQuantidade() );

        return detalhePedidoDto.build();
    }

    @Override
    public DetalhePedido toEntity(DetalhePedidoDto dto) {
        if ( dto == null ) {
            return null;
        }

        DetalhePedido.DetalhePedidoBuilder detalhePedido = DetalhePedido.builder();

        detalhePedido.id( detalhePedidoDtoToDetalhePedidoId( dto ) );
        detalhePedido.desconto( dto.getDesconto() );
        detalhePedido.precoVenda( dto.getPrecoVenda() );
        detalhePedido.quantidade( dto.getQuantidade() );

        return detalhePedido.build();
    }

    @Override
    public List<DetalhePedidoDto> toDtoList(List<DetalhePedido> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DetalhePedidoDto> list = new ArrayList<DetalhePedidoDto>( entities.size() );
        for ( DetalhePedido detalhePedido : entities ) {
            list.add( toDto( detalhePedido ) );
        }

        return list;
    }

    @Override
    public List<DetalhePedido> toEntityList(List<DetalhePedidoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<DetalhePedido> list = new ArrayList<DetalhePedido>( dtos.size() );
        for ( DetalhePedidoDto detalhePedidoDto : dtos ) {
            list.add( toEntity( detalhePedidoDto ) );
        }

        return list;
    }

    private Integer entityIdPedidoId(DetalhePedido detalhePedido) {
        DetalhePedidoId id = detalhePedido.getId();
        if ( id == null ) {
            return null;
        }
        return id.getPedidoId();
    }

    private Integer entityIdProdutoId(DetalhePedido detalhePedido) {
        DetalhePedidoId id = detalhePedido.getId();
        if ( id == null ) {
            return null;
        }
        return id.getProdutoId();
    }

    protected DetalhePedidoId detalhePedidoDtoToDetalhePedidoId(DetalhePedidoDto detalhePedidoDto) {
        if ( detalhePedidoDto == null ) {
            return null;
        }

        DetalhePedidoId.DetalhePedidoIdBuilder detalhePedidoId = DetalhePedidoId.builder();

        detalhePedidoId.pedidoId( detalhePedidoDto.getPedidoId() );
        detalhePedidoId.produtoId( detalhePedidoDto.getProdutoId() );

        return detalhePedidoId.build();
    }
}
