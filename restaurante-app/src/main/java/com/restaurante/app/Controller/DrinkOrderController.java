package com.restaurante.app.Controller;
import com.restaurante.app.dto.DishOrder;
import com.restaurante.app.dto.DrinkOrder;
import com.restaurante.app.dto.DrinkOrderView;
import com.restaurante.app.entity.PedidoBebida;
import com.restaurante.app.mapper.DrinkOrderMapper;
import com.restaurante.app.service.DrinkOrderService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinkorders")
public class DrinkOrderController {

    @Autowired
    private DrinkOrderService drinkOrderService;

    @Autowired
    private DrinkOrderMapper drinkOrderMapper;

    @GetMapping("/all")
    public ResponseEntity<List<DrinkOrder>> getAllDrinkOrders() {
        try {
            return new ResponseEntity<>(drinkOrderService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<DrinkOrder> saveDrinkOrder(
            @RequestParam("orderId") long orderId,
            @RequestParam("drinkId") long drinkId,
            @RequestParam("quantity") long quantity) {

        try {
            drinkOrderService.saveDrinkOrder(orderId, drinkId, quantity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") Long id) {

        try {
            drinkOrderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DrinkOrder> findDrinkOrderById(@PathVariable Long id) {
        try {
            DrinkOrder drinkOrder = drinkOrderService.findById(id);
            return new ResponseEntity<>(drinkOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<List<DrinkOrderView>> viewDrinkOrders() {
        try {
            List<DrinkOrderView> drinkOrderView = drinkOrderService.viewDrinkOrders();
            return new ResponseEntity<>(drinkOrderView, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/quantity")
    public ResponseEntity<Long> getCantidadBebida(@RequestParam("id") long id) {
        try {
            Long cantidadBebida = drinkOrderService.drinkQuantity(id);
            return new ResponseEntity<>(cantidadBebida, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 404 Not Found

        }

    }
}
