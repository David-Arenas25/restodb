package com.restaurante.app.mapper;

import com.restaurante.app.dto.Table;
import com.restaurante.app.entity.Mesa;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TableMapper {
    @Mappings({
            @Mapping(source = "idMesa", target = "tableId"),
            @Mapping(source = "numeroMesa", target = "tableNumber"),
            @Mapping(source = "capacidad", target = "capacity"),
            @Mapping(source = "estadoMesa", target = "tableStatus")
    })
    Table toTable(Mesa mesa);

    List<Table> toTables(List<Mesa> mesas);

    @InheritInverseConfiguration
    Mesa toMesa(Table table);

    List<Mesa> toMesas(List<Table> tables);
}
