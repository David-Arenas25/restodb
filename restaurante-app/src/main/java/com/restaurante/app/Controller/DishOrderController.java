package com.restaurante.app.Controller;

import com.restaurante.app.dto.DishOrder;
import com.restaurante.app.dto.DishOrderView;
import com.restaurante.app.mapper.DishOrderMapper;
import com.restaurante.app.service.DishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishorders")
public class DishOrderController {

    @Autowired
    private DishOrderService dishOrderRepository;

    @Autowired
    private DishOrderMapper dishOrderMapper;

    @GetMapping("/all")
    public ResponseEntity<List<DishOrder>> getAllDishOrders() {
        try {
            return new ResponseEntity<>(dishOrderRepository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<DishOrder> saveDrinkOrder(
            @RequestParam("orderId") long orderId,
            @RequestParam("dishId") long dishId,
            @RequestParam("quantity") long quantity) {

        try {
            dishOrderRepository.saveDishOrder(orderId,dishId,quantity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            System.err.println("error"+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("orderId") Long orderId, @RequestParam("dishId") Long dishId) {
        try {
            dishOrderRepository.delete(orderId, dishId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DishOrder> findDishOrderById(@PathVariable Long id) {
        try {
            DishOrder dishOrder = dishOrderRepository.findById(id);
            return new ResponseEntity<>(dishOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<List<DishOrderView>> viewDrinkOrders() {
        try {
            List<DishOrderView> dishOrderView= dishOrderRepository.viewDishOrders();
            return new ResponseEntity<>(dishOrderView, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/quantity")
    public ResponseEntity<Long> getCantidadPlato(@RequestParam("id") long id) {
        try {
            Long cantidadPlato = dishOrderRepository.dishQuantity(id);
            return new ResponseEntity<>(cantidadPlato, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 404 Not Found

        }

    }


}
