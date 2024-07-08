package com.restaurante.app.repository;

import com.restaurante.app.dto.DishOrder;
import com.restaurante.app.entity.PedidoPlato;
import com.restaurante.app.mapper.DishOrderMapper;
import com.restaurante.app.repositorio.PedidoPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DishOrderRepository {

    @Autowired
    private PedidoPlatoRepository dishOrderRepository;

    @Autowired
    private DishOrderMapper dishOrderMapper;

    public List<DishOrder> getAll() {
        List<PedidoPlato> allPedidosPlatos = dishOrderRepository.findAll();
        return dishOrderMapper.toDishOrders(allPedidosPlatos);
    }

    /*public DishOrder save(DishOrder dishOrder) {
        PedidoPlato pedidoPlato = dishOrderMapper.toPedidoPlato(dishOrder);
        PedidoPlato savedPedidoPlato = dishOrderRepository.save(pedidoPlato);
        return dishOrderMapper.toDishOrder(savedPedidoPlato);
    }*/

    public void delete(Long id) {
        dishOrderRepository.borrarPedidoBebida(id);
    }

    public DishOrder findById(Long id) {
        PedidoPlato pedidoPlato = dishOrderRepository.findByIdIdPedido(id);
        return dishOrderMapper.toDishOrder(pedidoPlato);
    }


}
