package com.restaurante.app.mapper;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.dto.Order;
import com.restaurante.app.entity.Bebida;
import com.restaurante.app.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    @Mappings({
            @Mapping(source = "idPedido",target = "orderId"),
            @Mapping(source = "fechaPedido",target = "orderDate"),
            @Mapping(source = "estado",target = "status"),
            @Mapping(source = "idMesero",target = "waiterId"),
            @Mapping(source = "idMesa" , target = "tableId")
    })
    Order toOrder(Pedido pedido);
    List<Order> toOrders(List<Pedido> pedidos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedidoBebidas",ignore = true),
            @Mapping(target = "pedidoPlatos",ignore = true),
            @Mapping(target = "mesero",ignore = true),
            @Mapping(target = "mesas",ignore = true)
    })
    Pedido toPedido(Order order);
    List<Pedido> toPedidos(List<Order> orders);
}
