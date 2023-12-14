package com.example.pizza_service.service;

import com.example.pizza_service.dto.UserDTO;

import java.util.List;

public interface UserService {

    Long createUser(UserDTO user);

    UserDTO getById(Long id);

    List<UserDTO> getAll();
}
