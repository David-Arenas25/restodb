package com.restaurante.app.service;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.mapper.DrinkMapper;
import com.restaurante.app.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkMapper drinkMapper;

    public List<Drink> getAll() {
        try {
            return drinkRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las bebidas", e);
        }
    }

    public Drink save(Drink drink) {
        try {
            return drinkRepository.save(drink);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la bebida", e);
        }
    }

    public void delete(Long id) {
        try {
            drinkRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la bebida con ID: " + id, e);
        }
    }

    public Optional<Drink> findById(Long id) {
        try {
            return drinkRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la bebida con ID: " + id, e);
        }
    }

    public Drink findByName(String name) {
        try {
            return drinkRepository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la bebida por nombre: " + name, e);
        }
    }
}
