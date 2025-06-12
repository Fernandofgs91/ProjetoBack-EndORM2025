package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-11T22:36:16-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoDto toDto(Pedido entity) {
        if ( entity == null ) {
            return null;
        }

        PedidoDto.PedidoDtoBuilder pedidoDto = PedidoDto.builder();

        pedidoDto.clienteId( entityClienteId( entity ) );
        pedidoDto.dataPedido( entity.getDataPedido() );
        pedidoDto.detalhesPedido( detalhePedidoListToDetalhePedidoDtoList( entity.getDetalhesPedido() ) );
        pedidoDto.id( entity.getId() );

        return pedidoDto.build();
    }

    @Override
    public Pedido toEntity(PedidoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.cliente( pedidoDtoToCliente( dto ) );
        pedido.dataPedido( dto.getDataPedido() );
        pedido.detalhesPedido( detalhePedidoDtoListToDetalhePedidoList( dto.getDetalhesPedido() ) );
        pedido.id( dto.getId() );

        return pedido.build();
    }

    @Override
    public List<PedidoDto> toDtoList(List<Pedido> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PedidoDto> list = new ArrayList<PedidoDto>( entities.size() );
        for ( Pedido pedido : entities ) {
            list.add( toDto( pedido ) );
        }

        return list;
    }

    @Override
    public List<Pedido> toEntityList(List<PedidoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Pedido> list = new ArrayList<Pedido>( dtos.size() );
        for ( PedidoDto pedidoDto : dtos ) {
            list.add( toEntity( pedidoDto ) );
        }

        return list;
    }

    private String entityClienteId(Pedido pedido) {
        Cliente cliente = pedido.getCliente();
        if ( cliente == null ) {
            return null;
        }
        return cliente.getId();
    }

    protected DetalhePedidoDto detalhePedidoToDetalhePedidoDto(DetalhePedido detalhePedido) {
        if ( detalhePedido == null ) {
            return null;
        }

        DetalhePedidoDto.DetalhePedidoDtoBuilder detalhePedidoDto = DetalhePedidoDto.builder();

        detalhePedidoDto.desconto( detalhePedido.getDesconto() );
        detalhePedidoDto.precoVenda( detalhePedido.getPrecoVenda() );
        detalhePedidoDto.quantidade( detalhePedido.getQuantidade() );

        return detalhePedidoDto.build();
    }

    protected List<DetalhePedidoDto> detalhePedidoListToDetalhePedidoDtoList(List<DetalhePedido> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalhePedidoDto> list1 = new ArrayList<DetalhePedidoDto>( list.size() );
        for ( DetalhePedido detalhePedido : list ) {
            list1.add( detalhePedidoToDetalhePedidoDto( detalhePedido ) );
        }

        return list1;
    }

    protected Cliente pedidoDtoToCliente(PedidoDto pedidoDto) {
        if ( pedidoDto == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.id( pedidoDto.getClienteId() );

        return cliente.build();
    }

    protected DetalhePedido detalhePedidoDtoToDetalhePedido(DetalhePedidoDto detalhePedidoDto) {
        if ( detalhePedidoDto == null ) {
            return null;
        }

        DetalhePedido.DetalhePedidoBuilder detalhePedido = DetalhePedido.builder();

        detalhePedido.desconto( detalhePedidoDto.getDesconto() );
        detalhePedido.precoVenda( detalhePedidoDto.getPrecoVenda() );
        detalhePedido.quantidade( detalhePedidoDto.getQuantidade() );

        return detalhePedido.build();
    }

    protected List<DetalhePedido> detalhePedidoDtoListToDetalhePedidoList(List<DetalhePedidoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalhePedido> list1 = new ArrayList<DetalhePedido>( list.size() );
        for ( DetalhePedidoDto detalhePedidoDto : list ) {
            list1.add( detalhePedidoDtoToDetalhePedido( detalhePedidoDto ) );
        }

        return list1;
    }
}
