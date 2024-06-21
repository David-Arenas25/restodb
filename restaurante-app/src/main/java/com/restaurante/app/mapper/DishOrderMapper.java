package com.restaurante.app.mapper;
import com.restaurante.app.dto.DishOrder;
import com.restaurante.app.entity.PedidoPlato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {OrderMapper.class, DishMapper.class})
public interface DishOrderMapper {


    @Mappings({
            @Mapping(source = "id.idPlato",target = "dishId"),
            @Mapping(source = "id.idPedido",target = "orderId"),
            @Mapping(source = "cantidad",target = "quantity"),
    })
    DishOrder toDishOrder(PedidoPlato pedidoPlato);
    List<DishOrder> toDishOrders(List<PedidoPlato> pedidoPlato);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedido",ignore = true),
            @Mapping(target = "plato",ignore = true),
            @Mapping(target = "id",ignore = true)

    })
    PedidoPlato toPedidoPlato(DishOrder dishOrder);
    List<PedidoPlato> toPedidoPlatos(List<DishOrder> dishOrders);
}
