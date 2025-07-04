package com.restaurante.app.repositorio;

import com.restaurante.app.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
}
