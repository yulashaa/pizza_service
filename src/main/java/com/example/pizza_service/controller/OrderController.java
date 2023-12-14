package com.example.pizza_service.controller;

import com.example.pizza_service.dto.IdDTO;
import com.example.pizza_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //confirm orderx
    @PostMapping("/confirm") //body {"id": 1}
    public ResponseEntity confirmOrder(@Valid @RequestBody IdDTO idDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.confirmOrder(idDTO.getId()));
    }

    //get order
    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }

    //get user orders
    @GetMapping("/user/{id}")
    public ResponseEntity getUserOrders(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getUserOrders(id));
    }
}
