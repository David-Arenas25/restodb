package com.restaurante.app.repository;

import com.restaurante.app.dto.DrinkOrder;
import com.restaurante.app.dto.DrinkOrderView;
import com.restaurante.app.entity.PedidoBebida;
import com.restaurante.app.mapper.DishOrderMapper;
import com.restaurante.app.mapper.DrinkOrderMapper;
import com.restaurante.app.repositorio.PedidoBebidaRepository;
import com.restaurante.app.repositorio.PedidoBebidaViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DrinkOrderRepository {

    @Autowired
    private PedidoBebidaRepository drinkOrderRepository;

    @Autowired
    private DrinkOrderMapper drinkOrderMapper;

    public List<DrinkOrder> getAll() {
        List<PedidoBebida> allPedidosBebidas = drinkOrderRepository.findAll();
        return drinkOrderMapper.toDrinkOrders(allPedidosBebidas);
    }

   /* public DrinkOrder save(long idPedido, long idBebida, long cantidad) {
        PedidoBebida pedidoBebida = drinkOrderMapper.toPedidoBebida(idPedido,idBebida,cantidad);
        return drinkOrderMapper.toDrinkOrder(pedidoBebida);
    }*/

    public void delete(Long orderId, Long drinkId) {
        drinkOrderRepository.borrarPedidoBebida(orderId,drinkId);
    }

    public DrinkOrder findById(Long id) {
        PedidoBebida pedidoBebida = drinkOrderRepository.findByIdIdPedido(id);
        return drinkOrderMapper.toDrinkOrder(pedidoBebida);
    }


}
