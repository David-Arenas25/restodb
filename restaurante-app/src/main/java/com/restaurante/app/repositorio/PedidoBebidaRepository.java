package com.restaurante.app.repositorio;
import com.restaurante.app.entity.PedidoBebida;
import com.restaurante.app.entity.PedidoBebidaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoBebidaRepository extends JpaRepository<PedidoBebida, PedidoBebidaId> {
    //@Modifying
    //@Transactional
    @Query(value = "CALL borrar_pedido_bebida(:pID_PEDIDO)", nativeQuery = true)
    void borrarPedidoBebida(@Param("pID_PEDIDO") Long pID_PEDIDO);
    @Procedure("PEDIR_BEBIDA")
    void pedirBebida(@Param("pID_PEDIDO") Long idPedido,
                     @Param("pID_BEBIDA") Long idBebida,
                     @Param("pCANTIDAD") Long cantidad);

    @Query(value = "SELECT cantidad_bebida(:idPedido) AS total_bebidas FROM dual", nativeQuery = true)
    Long cantidadBebida(@Param("idPedido") Long idPedido);
    PedidoBebida findByIdIdPedido(long orderId);
}

