package com.restaurante.app.repositorio;

import com.restaurante.app.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {
    Bebida findByNombreBebida(String nombreBebida);

}
