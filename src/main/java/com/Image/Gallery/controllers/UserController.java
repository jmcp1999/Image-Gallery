package com.Image.Gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Image.Gallery.models.User;
import com.Image.Gallery.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }
}
