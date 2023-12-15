package com.example.pizza_service.controller;

import com.example.pizza_service.dto.AddPizzaDTO;
import com.example.pizza_service.dto.IdDTO;
import com.example.pizza_service.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/add")
    public ResponseEntity<IdDTO> addPizza(@Valid @RequestBody AddPizzaDTO pizza) {
        Long userId = pizza.getUserId();
        IdDTO idDTO = new IdDTO(pizzaService.addPizza(userId, pizza));
        return ResponseEntity.status(HttpStatus.CREATED).body(idDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.getAll());
    }
}
