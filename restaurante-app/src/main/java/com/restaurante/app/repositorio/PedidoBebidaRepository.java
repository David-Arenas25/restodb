package com.restaurante.app.repositorio;
import com.restaurante.app.entity.PedidoBebida;
import com.restaurante.app.entity.PedidoBebidaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoBebidaRepository extends JpaRepository<PedidoBebida, PedidoBebidaId> {
    PedidoBebida findByIdIdPedido(long orderId);
    PedidoBebida deleteByIdIdPedido(long orderId);
    @Procedure("PEDIR_BEBIDA")
    void pedirBebida(@Param("pID_PEDIDO") Long idPedido,
                     @Param("pID_BEBIDA") Long idBebida,
                     @Param("pCANTIDAD") Long cantidad);
}

