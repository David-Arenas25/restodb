package com.restaurante.app.mapper;
import com.restaurante.app.dto.Waiter;
import com.restaurante.app.entity.Mesero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WaiterMapper {


    @Mappings({
            @Mapping(source = "idMesero",target = "waiterId"),
            @Mapping(source = "nombreMesero",target = "waiterName"),
            @Mapping(source = "apellidoMesero",target = "waiterLastName"),
    })
    Waiter toWaiter(Mesero mesero);
    List<Waiter> toWaiters(List<Mesero> meseros);

    @InheritInverseConfiguration
    Mesero toMesero(Waiter waiter);
    List<Mesero> toMeseros(List<Waiter> waiters);
}
