package com.restaurante.app.repositorio;
import com.restaurante.app.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {


    @Procedure("total")
    void total(@Param("Pid_pedido") Long idPedido);

    @Procedure("ACTUALIZAR_TOTAL_PEDIDO")
    void actualizar(@Param("pID_PEDIDO") Long idPedido);

    @Procedure("PAGAR")
    void pagar(@Param("pTOTAL") Float total, @Param("pID_PEDIDO")Long idPedido);


}
