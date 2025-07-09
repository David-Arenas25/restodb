package com.restaurante.app.repositorio;

import com.restaurante.app.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
@Procedure(procedureName = "estadoMesa")
void estadoMesa(@Param("id_mesa") int idMesa, @Param("estado") String estado);
}
