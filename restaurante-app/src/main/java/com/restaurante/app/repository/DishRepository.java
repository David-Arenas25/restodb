package com.restaurante.app.repository;

import com.restaurante.app.dto.Dish;
import com.restaurante.app.entity.Plato;
import com.restaurante.app.mapper.DishMapper;
import com.restaurante.app.repositorio.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepository {

    @Autowired
    private PlatoRepository dishRepository;

    @Autowired
    private DishMapper dishMapper;

    public List<Dish> getAll() {
        List<Plato> allPlatos = dishRepository.findAll();
        return dishMapper.toDishes(allPlatos);
    }

    public Dish save(Dish dish) {
        Plato plato = dishMapper.toPlato(dish);
        Plato savedPlato = dishRepository.save(plato);
        return dishMapper.toDish(savedPlato);
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    public Optional<Dish> findById(Long id) {
        Optional<Plato> optionalPlato = dishRepository.findById(id);
        return optionalPlato.map(plato -> dishMapper.toDish(plato));
    }

    public Dish findByName(String name) {
        Plato plato = dishRepository.findByNombrePlato(name);
        return dishMapper.toDish(plato);
    }
}
