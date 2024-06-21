package com.restaurante.app.Controller;

import com.restaurante.app.dto.Drink;
import com.restaurante.app.mapper.DrinkMapper;
import com.restaurante.app.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkMapper drinkMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        try {
            return new ResponseEntity<>(drinkRepository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Drink> save(@RequestBody Drink drink) {
        try {
            return new ResponseEntity<>(drinkRepository.save(drink), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            drinkRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Drink>> findDrinkById(@PathVariable Long id) {
        try {
            Optional<Drink> drink = drinkRepository.findById(id);
            return new ResponseEntity<>(drink, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Drink> findDrinkByName(@PathVariable String name) {
        try {
            Drink drink = drinkRepository.findByName(name);
            return new ResponseEntity<>(drink, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
