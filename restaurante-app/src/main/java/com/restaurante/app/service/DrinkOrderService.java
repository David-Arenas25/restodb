package com.restaurante.app.service;

import com.restaurante.app.dto.DrinkOrder;
import com.restaurante.app.dto.DrinkOrderView;
import com.restaurante.app.entity.PedidoBebida;
import com.restaurante.app.mapper.DrinkOrderMapper;
import com.restaurante.app.repositorio.PedidoBebidaRepository;
import com.restaurante.app.repositorio.PedidoBebidaViewRepository;
import com.restaurante.app.repository.DrinkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DrinkOrderService {

    @Autowired
    private DrinkOrderRepository drinkOrderRepository;
    @Autowired
    private PedidoBebidaViewRepository drinkOrderViewRepository;

    @Autowired
    private PedidoBebidaRepository pedidoBebidaRepository;

    @Autowired
    private DrinkOrderMapper drinkOrderMapper;

    public List<DrinkOrder> getAll() {
        try {
            return drinkOrderRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las órdenes de bebidas", e);
        }
    }

    public void saveDrinkOrder(long orderId, long drinkId, long quantity) {

        pedidoBebidaRepository.pedirBebida(orderId,drinkId,quantity);



    }

    public void delete(Long id) {
        try {
            drinkOrderRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la orden de bebida con ID: " + id, e);
        }
    }

    public DrinkOrder findById(Long id) {
        try {
            return drinkOrderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la orden de bebida con ID: " + id, e);
        }
    }


    public List<DrinkOrderView> viewDrinkOrders() {
        try {
            return drinkOrderViewRepository.findAllPedidosBebida();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la orden de bebida con ID: " + e.getMessage());
        }



    }




    public long drinkQuantity(long orderId , long drinkId){
        return pedidoBebidaRepository.cantidadBebida(orderId,drinkId);
    }



}
