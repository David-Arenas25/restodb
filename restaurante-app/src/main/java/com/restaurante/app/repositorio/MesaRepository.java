package com.restaurante.app.repositorio;

import com.restaurante.app.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
@Procedure(procedureName = "estadoMesa")
void estadoMesa(@Param("id_mesa") int idMesa, @Param("estado") String estado);
}
