package com.twistedspur.controller;

import com.twistedspur.dto.LoginRequest;
import com.twistedspur.dto.UserDto;
import com.twistedspur.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "Operations to perform user management")
public class UserController {

    @Autowired
    UserService userService;

    // Create a new User
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    // Get all Users
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get a single User by ID
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Update a User
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/login")
    public void attemptLogin(@RequestBody LoginRequest loginRequest) {
        userService.attemptLogin(loginRequest);
    }
}
