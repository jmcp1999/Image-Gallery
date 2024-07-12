package com.Image.Gallery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Image.Gallery.models.User;
import com.Image.Gallery.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para obtener un usuario por su ID
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
