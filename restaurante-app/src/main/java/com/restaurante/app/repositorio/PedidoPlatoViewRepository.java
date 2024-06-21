package com.restaurante.app.repositorio;

import com.restaurante.app.dto.DishOrderView;
import com.restaurante.app.dto.DrinkOrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoPlatoViewRepository extends JpaRepository<DishOrderView,Long> {
    @Query(value = "SELECT * FROM pedido_platos", nativeQuery = true)
    List<DishOrderView> findAllPedidosPlato();


}
