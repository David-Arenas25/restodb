package com.restaurante.app.repositorio;

import com.restaurante.app.entity.PedidoPlato;
import com.restaurante.app.entity.PedidoPlatoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoPlatoRepository extends JpaRepository<PedidoPlato, PedidoPlatoId> {

    PedidoPlato findByIdIdPedido(long orderId);

    PedidoPlato deleteByIdIdPedido(long orderId);

    @Procedure("pedir_plato")
    void pedirPlato(@Param("pID_PEDIDO") Long idPedido,
                    @Param("pID_PLATO") Long idPlato,
                    @Param("pCANTIDAD") Long cantidad);


}