package com.restaurante.app.service;

import com.restaurante.app.dto.Waiter;
import com.restaurante.app.mapper.WaiterMapper;
import com.restaurante.app.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterService {

    @Autowired
    private WaiterRepository waiterRepository;

    @Autowired
    private WaiterMapper waiterMapper;

    public List<Waiter> getAll() {
        try {
            return waiterRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todos los camareros", e);
        }
    }

    public Waiter save(Waiter waiter) {
        try {
            return waiterRepository.save(waiter);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el camarero", e);
        }
    }

    public void delete(Long id) {
        try {
            waiterRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el camarero con ID: " + id, e);
        }
    }

    public Optional<Waiter> findById(Long id) {
        try {
            return waiterRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el camarero con ID: " + id, e);
        }
    }

    public Waiter findByName(String name) {
        try {
            return waiterRepository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el camarero por nombre: " + name, e);
        }
    }
}
