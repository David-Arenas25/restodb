package com.restaurante.app.Controller;

import com.restaurante.app.dto.Waiter;
import com.restaurante.app.mapper.WaiterMapper;
import com.restaurante.app.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/waiters")
public class WaiterController {

    @Autowired
    private WaiterRepository waiterRepository;

    @Autowired
    private WaiterMapper waiterMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Waiter>> getAllWaiters() {
        try {
            return new ResponseEntity<>(waiterRepository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Waiter> save(@RequestBody Waiter waiter) {
        try {
            return new ResponseEntity<>(waiterRepository.save(waiter), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            waiterRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Waiter>> findWaiterById(@PathVariable Long id) {
        try {
            Optional<Waiter> waiter = waiterRepository.findById(id);
            return new ResponseEntity<>(waiter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Waiter> findWaiterByName(@PathVariable String name) {
        try {
            Waiter waiter = waiterRepository.findByName(name);
            return new ResponseEntity<>(waiter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
