package com.restaurante.app.repositorio;

import com.restaurante.app.entity.Mesero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeseroRepository extends JpaRepository<Mesero,Long> {

    Mesero findByNombreMesero(String nombreMesero);
}
