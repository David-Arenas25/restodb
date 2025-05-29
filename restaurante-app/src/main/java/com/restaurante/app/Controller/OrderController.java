package com.restaurante.app.Controller;

import com.restaurante.app.dto.Order;
import com.restaurante.app.mapper.OrderMapper;
import com.restaurante.app.repositorio.PedidoRepository;
import com.restaurante.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            return new ResponseEntity<>(orderRepository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        try {
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            orderRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Order>> findOrderById(@PathVariable Long id) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Order> total(@RequestParam("id") Long id){
        try {
            pedidoRepository.total(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println("Error"+id+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    @GetMapping("/update")
    public ResponseEntity<?> updateTotal(@RequestParam("id") Long id){
        try {
            this.pedidoRepository.actualizar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println("Error"+id+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pagar")
    public ResponseEntity<Optional<Order>> pagar(@RequestParam("total") float total,@RequestParam("orderId") Long orderId){
        try {
            pedidoRepository.pagar(total,orderId);
            return new ResponseEntity<>(orderRepository.findById(orderId),HttpStatus.OK);
        }catch (Exception e){
            System.err.println("Error"+orderId+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
