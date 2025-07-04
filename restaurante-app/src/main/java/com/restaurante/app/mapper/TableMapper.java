package com.restaurante.app.mapper;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.dto.Order;
import com.restaurante.app.dto.Table;
import com.restaurante.app.entity.Bebida;
import com.restaurante.app.entity.Mesa;
import com.restaurante.app.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface TableMapper {


    @Mappings({
            @Mapping(source = "idMesa",target = "tableId"),
            @Mapping(source = "numeroMesa",target = "tableNumber"),
            @Mapping(source = "estadoMesa",target = "tableStatus"),
            @Mapping(source = "capacidad",target = "capacity"),
            @Mapping(source = "pedidos", target = "orders")
    })
    Table toTable(Mesa mesa);
    List<Table> toTables(List<Mesa> mesa);

    @InheritInverseConfiguration
    @Mappings({
    })
    Mesa toMesa(Table table);
    List<Mesa> toMesas(List<Table> table);
}
