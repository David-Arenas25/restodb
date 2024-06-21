package com.restaurante.app.mapper;

import com.restaurante.app.dto.DrinkOrder;
import com.restaurante.app.entity.PedidoBebida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, DrinkMapper.class})
public interface DrinkOrderMapper {

    @Mappings({
            @Mapping(source = "id.idBebida", target = "drinkId"),
            @Mapping(source = "id.idPedido", target = "orderId"),
            @Mapping(source = "cantidad", target = "quantity"),
    })
    DrinkOrder toDrinkOrder(PedidoBebida pedidoBebida);

    List<DrinkOrder> toDrinkOrders(List<PedidoBebida> pedidoBebidas);


    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedido", ignore = true),
            @Mapping(target = "bebida", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    PedidoBebida toPedidoBebida(DrinkOrder drinkOrder);

    List<PedidoBebida> toPedidoBebidas(List<DrinkOrder> drinkOrders);
}
