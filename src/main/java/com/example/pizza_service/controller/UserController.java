package com.example.pizza_service.controller;


import com.example.pizza_service.dto.IdDTO;
import com.example.pizza_service.dto.UserDTO;
import com.example.pizza_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable final Long id) {
        final UserDTO user = service.getById(id);

        return user == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody final UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new IdDTO(service.createUser(user)));
    }

}
