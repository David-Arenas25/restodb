package com.restaurante.app.repositorio;
import com.restaurante.app.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    @Procedure(procedureName = "total", outputParameterName = "Total_resultado")
    Float calculateTotal(@Param("Pid_pedido") Long pedidoId);
      @Procedure(procedureName = "ACTUALIZAR_TOTAL_PEDIDO", outputParameterName = "TOTAL_PEDIDO")
    Float actualizar(@Param("pID_PEDIDO") Long pID_PEDIDO);

    @Procedure("PAGAR")
    void pagar(@Param("pTOTAL") Float total, @Param("pID_PEDIDO")Long idPedido);


}
