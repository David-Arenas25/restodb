package com.restaurante.app.Controller;


import com.restaurante.app.dto.Dish;
import com.restaurante.app.mapper.DishMapper;
import com.restaurante.app.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishMapper dishMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Dish>> getAll() {
        try {
            return new ResponseEntity<>(dishRepository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("save")
    public ResponseEntity<Dish> save(@RequestBody Dish dish) {
        try {
            return new ResponseEntity<>(dishRepository.save(dish),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("delete/id")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            dishRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Optional<Dish>> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(dishRepository.findById(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("name/{name}")
    public ResponseEntity<Dish> findByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(dishRepository.findByName(name),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
