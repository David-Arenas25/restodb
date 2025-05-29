package com.restaurante.app.service;

import com.restaurante.app.dto.Order;
import com.restaurante.app.mapper.OrderMapper;
import com.restaurante.app.repositorio.PedidoRepository;
import com.restaurante.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAll() {
        try {
            return orderRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las órdenes", e);
        }
    }

    public Order save(Order order) {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la orden", e);
        }
    }

    public void delete(Long id) {
        try {
            orderRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la orden con ID: " + id, e);
        }
    }

    public Optional<Order> findById(Long id) {
        try {
            return orderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la orden con ID: " + id, e);
        }
    }


    public void total(Long id){
        try {
            orderRepository.total(id);
        }catch (Exception e){
            System.err.println("Error"+id+e.getMessage());
        }
    }    public Float updateTotal(Long id){
        try {
            return orderRepository.updateTotal(id);
        }catch (Exception e){
            System.err.println("Error"+id+e.getMessage());
            throw new RuntimeException("Error al actualizar el total del pedido: " + id, e);
        }
    }

    public void pagar(Float total, Long orderId){
        try {
            pedidoRepository.pagar(total,orderId);
        }catch (Exception e){
            System.err.println("Error"+orderId+e.getMessage());
        }
    }



}
