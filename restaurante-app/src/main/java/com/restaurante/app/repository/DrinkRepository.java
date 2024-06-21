package com.restaurante.app.repository;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.entity.Bebida;
import com.restaurante.app.mapper.DrinkMapper;
import com.restaurante.app.repositorio.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DrinkRepository {

    @Autowired
    private BebidaRepository drinkRepository;

    @Autowired
    private DrinkMapper drinkMapper;

    public List<Drink> getAll() {
        List<Bebida> allBebidas = drinkRepository.findAll();
        return drinkMapper.toDrinks(allBebidas);
    }

    public Drink save(Drink drink) {
        Bebida bebida = drinkMapper.toBebida(drink);
        Bebida savedBebida = drinkRepository.save(bebida);
        return drinkMapper.toDrink(savedBebida);
    }

    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }

    public Optional<Drink> findById(Long id) {
        Optional<Bebida> optionalBebida = drinkRepository.findById(id);
        return optionalBebida.map(bebida -> drinkMapper.toDrink(bebida));
    }

    public Drink findByName(String name) {
        Bebida bebida = drinkRepository.findByNombreBebida(name);
        return drinkMapper.toDrink(bebida);
    }
}
