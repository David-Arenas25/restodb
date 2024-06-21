package com.restaurante.app.mapper;
import com.restaurante.app.dto.Dish;
import com.restaurante.app.entity.Plato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {


    @Mappings({
            @Mapping(source = "idPlato",target = "dishId"),
            @Mapping(source = "nombrePlato",target = "dishName"),
            @Mapping(source = "descripcionPlato",target = "dishDescription"),
            @Mapping(source = "precioPlato",target = "dishPrice")
    })
    Dish toDish(Plato plato);
    List<Dish> toDishes(List<Plato> platos);

    @InheritInverseConfiguration
    @Mapping(target = "pedidoPlato",ignore = true)
    Plato toPlato(Dish dish);
    List<Plato> toPlatos(List<Dish> dishes);
}
