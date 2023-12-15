package com.example.pizza_service.controller;

import com.example.pizza_service.dto.IdDTO;
import com.example.pizza_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/confirm")
    public ResponseEntity confirmOrder(@Valid @RequestBody IdDTO idDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.confirmOrder(idDTO.getId()));
    }
  
    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserOrders(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getUserOrders(id));
    }
}
