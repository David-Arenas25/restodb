package com.restaurante.app.repositorio;
import com.restaurante.app.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato,Long> {

    Plato findByNombrePlato(String nombrePlato);
}
