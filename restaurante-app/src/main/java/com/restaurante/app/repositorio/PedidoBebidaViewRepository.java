package com.restaurante.app.repositorio;

import com.restaurante.app.dto.DrinkOrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoBebidaViewRepository extends JpaRepository<DrinkOrderView,Long> {
    @Query(value = "SELECT * FROM pedido_bebidas", nativeQuery = true)
    List<DrinkOrderView> findAllPedidosBebida();


}
