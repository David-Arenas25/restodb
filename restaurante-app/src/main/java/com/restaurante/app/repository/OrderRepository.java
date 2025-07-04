package com.restaurante.app.repository;
import com.restaurante.app.dto.Order;
import com.restaurante.app.entity.Pedido;
import com.restaurante.app.mapper.OrderMapper;
import com.restaurante.app.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private PedidoRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAll() {
        List<Pedido> allPedidos = orderRepository.findAll();
        return orderMapper.toOrders(allPedidos);
    }

    public Order save(Order order) {
        Pedido pedido = orderMapper.toPedido(order);
        Pedido savedPedido = orderRepository.save(pedido);
        return orderMapper.toOrder(savedPedido);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> findById(Long id) {
        Optional<Pedido> optionalPedido = orderRepository.findById(id);
        return optionalPedido.map(pedido -> orderMapper.toOrder(pedido));
    }


    public Float total(Long id){
        return orderRepository.calculateTotal(id);
    }

    public void updateTotal(Long id){orderRepository.actualizar(id);}



}

