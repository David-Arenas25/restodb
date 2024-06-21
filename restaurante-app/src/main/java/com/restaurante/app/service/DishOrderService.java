package com.restaurante.app.service;

import com.restaurante.app.dto.DishOrder;
import com.restaurante.app.dto.DishOrderView;
import com.restaurante.app.dto.DrinkOrderView;
import com.restaurante.app.mapper.DishOrderMapper;
import com.restaurante.app.repositorio.PedidoPlatoRepository;
import com.restaurante.app.repositorio.PedidoPlatoViewRepository;
import com.restaurante.app.repository.DishOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishOrderService {

    @Autowired
    private DishOrderRepository dishOrderRepository;
    @Autowired
    private PedidoPlatoRepository pedidoPlatoRepository;
    @Autowired
    private PedidoPlatoViewRepository pedidoPlatoViewRepository;
    @Autowired
    private DishOrderMapper dishOrderMapper;

    public List<DishOrder> getAll() {
        try {
            return dishOrderRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las órdenes de platos", e);
        }
    }

    public void saveDishOrder(long orderId, long dishId, long quantity) {

        pedidoPlatoRepository.pedirPlato(orderId,dishId,quantity);


    }

    public void delete(Long id) {
        try {
            dishOrderRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la orden de plato con ID: " + id, e);
        }
    }

    public DishOrder findById(Long id) {
        try {
            return dishOrderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la orden de plato con ID: " + id, e);
        }
    }


    public List<DishOrderView> viewDishOrders() {
        try {
            return pedidoPlatoViewRepository.findAllPedidosPlato();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la orden de bebida con ID: " + e.getMessage());
        }
    }

}
