package com.restaurante.app.repository;

import com.restaurante.app.dto.Waiter;
import com.restaurante.app.entity.Mesero;
import com.restaurante.app.mapper.WaiterMapper;
import com.restaurante.app.repositorio.MeseroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class WaiterRepository {

    @Autowired
    private MeseroRepository waiterRepository;

    @Autowired
    private WaiterMapper waiterMapper;

    public List<Waiter> getAll() {
        List<Mesero> allMeseros = waiterRepository.findAll();
        return waiterMapper.toWaiters(allMeseros);
    }

    public Waiter save(Waiter waiter) {
        Mesero mesero = waiterMapper.toMesero(waiter);
        Mesero savedMesero = waiterRepository.save(mesero);
        return waiterMapper.toWaiter(savedMesero);
    }

    public void delete(Long id) {
        waiterRepository.deleteById(id);
    }

    public Optional<Waiter> findById(Long id) {
        Optional<Mesero> optionalMesero = waiterRepository.findById(id);
        return optionalMesero.map(mesero -> waiterMapper.toWaiter(mesero));
    }

    public Waiter findByName(String name) {
        Mesero mesero = waiterRepository.findByNombreMesero(name);
        return waiterMapper.toWaiter(mesero);
    }
}
