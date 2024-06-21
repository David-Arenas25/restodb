package com.restaurante.app.mapper;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.entity.Bebida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrinkMapper {


    @Mappings({
            @Mapping(source = "idBebida",target = "drinkId"),
            @Mapping(source = "nombreBebida",target = "drinkName"),
            @Mapping(source = "descripcionBebida",target = "drinkDescription"),
            @Mapping(source = "precioBebida",target = "drinkPrice")
    })
    Drink toDrink(Bebida bebida);
    List<Drink> toDrinks(List<Bebida> bebidas);

    @InheritInverseConfiguration
    @Mapping(target = "pedidoBebidas",ignore = true)
    Bebida toBebida(Drink drink);
    List<Bebida> toBebidas(List<Drink> drinks);
}
