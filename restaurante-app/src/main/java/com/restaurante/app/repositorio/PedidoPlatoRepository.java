package com.restaurante.app.repositorio;

import com.restaurante.app.entity.PedidoPlato;
import com.restaurante.app.entity.PedidoPlatoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoPlatoRepository extends JpaRepository<PedidoPlato, PedidoPlatoId> {

    PedidoPlato findByIdIdPedido(long orderId);
    //@Modifying
    //@Transactional
    @Query(value = "CALL borrar_pedido_plato(:pID_PEDIDO)", nativeQuery = true)
    void borrarPedidoBebida(@Param("pID_PEDIDO") Long pID_PEDIDO);

    @Procedure("pedir_plato")
    void pedirPlato(@Param("pID_PEDIDO") Long idPedido,
                    @Param("pID_PLATO") Long idPlato,
                    @Param("pCANTIDAD") Long cantidad);


    @Query(value = "SELECT cantidad_plato(:idPedido) AS total_platos FROM dual", nativeQuery = true)
    Long cantidadPlato(@Param("idPedido") Long idPedido);

}
