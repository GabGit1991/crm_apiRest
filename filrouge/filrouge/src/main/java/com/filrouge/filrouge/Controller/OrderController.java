package com.filrouge.filrouge.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.filrouge.filrouge.Model.Order;
import com.filrouge.filrouge.Service.OrderService;
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    @ResponseBody
    public ResponseEntity<String> getAllOrderss() {
        List<Order> listOrders = orderService.getAllOrder();
        return ResponseEntity.ok().body(listOrders.toString());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        if (optionalOrder.isPresent()) {
            Order orderFound = optionalOrder.get();
            return ResponseEntity.ok().body(orderFound);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Order> addOrders(@RequestBody Order order) {
        Order orderAdded = orderService.addOrder(order);
        return ResponseEntity.ok().body(orderAdded);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleeteOrder(@PathVariable("id") Integer id) {

        Boolean hasBeenDeleted = orderService.deleteOrderById(id);
        if (hasBeenDeleted) {
            return ResponseEntity.ok().body("Votre order a bien été modifié");
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<String>  modifierOrder(@PathVariable("id") Integer id, @RequestBody Order order) {
        Boolean hasBeenModified = orderService.modifyOrder(order, id);
        if (hasBeenModified) {
            return ResponseEntity.ok().body("Votre order a bien été modifié en : " + order.toString());
        }
        return ResponseEntity.notFound().build();
    }
    
}
