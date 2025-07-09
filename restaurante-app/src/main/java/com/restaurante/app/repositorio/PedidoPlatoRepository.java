package com.restaurante.app.repositorio;

import com.restaurante.app.entity.PedidoPlato;
import com.restaurante.app.entity.PedidoPlatoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PedidoPlatoRepository extends JpaRepository<PedidoPlato, PedidoPlatoId> {

    PedidoPlato findByIdIdPedido(long orderId);
    @Modifying
    @Transactional
    @Query(value = "EXEC borrar_pedido_plato :pID_PEDIDO, :pID_PLATO", nativeQuery = true)
    void borrarPedidoPlato(@Param("pID_PEDIDO") Long idPedido, @Param("pID_PLATO") Long idPlato);


    @Procedure("pedir_plato")
    void pedirPlato(@Param("pID_PEDIDO") Long idPedido,
                    @Param("pID_PLATO") Long idPlato,
                    @Param("pCANTIDAD") Long cantidad);


    @Query(value = "SELECT dbo.cantidad_plato(:p_id_pedido, :p_id_plato)", nativeQuery = true)
    Long cantidadPlato(@Param("p_id_pedido") Long idPedido, @Param("p_id_plato") Long idPlato);


}
