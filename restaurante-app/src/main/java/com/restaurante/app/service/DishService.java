package com.restaurante.app.service;

import com.restaurante.app.dto.Dish;
import com.restaurante.app.mapper.DishMapper;
import com.restaurante.app.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishMapper dishMapper;

    public List<Dish> getAll() {
        try {
            return dishRepository.getAll();
        } catch (Exception e) {
            // Aquí puedes manejar la excepción como desees, por ejemplo, loguearla
            throw new RuntimeException("Error al obtener todos los platos", e);
        }
    }

    public Dish save(Dish dish) {
        try {
            return dishRepository.save(dish);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el plato", e);
        }
    }

    public void delete(Long id) {
        try {
            dishRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el plato con ID: " + id, e);
        }
    }

    public Optional<Dish> findById(Long id) {
        try {
            return dishRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el plato con ID: " + id, e);
        }
    }

    public Dish findByName(String name) {
        try {
            return dishRepository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el plato por nombre: " + name, e);
        }
    }
}
