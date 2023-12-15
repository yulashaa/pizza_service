package com.example.pizza_service.service.impl;


import com.example.pizza_service.dto.UserDTO;
import com.example.pizza_service.entity.User;
import com.example.pizza_service.repository.UserRepository;
import com.example.pizza_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(UserDTO userDTO) {
        final User user = userRepository.save(UserDTO.fromDTO(userDTO));
        return user.getId();
    }

    @Override
    public UserDTO getById(Long id) {
        final Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserDTO::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserDTO::toDTO).toList();
    }
}
