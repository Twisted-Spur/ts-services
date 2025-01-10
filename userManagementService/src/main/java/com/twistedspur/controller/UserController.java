package com.twistedspur.controller;

import com.twistedspur.dto.UserDto;
import com.twistedspur.entity.User;
import com.twistedspur.mapper.UserMapper;
import com.twistedspur.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "Operations to perform user management")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    // Create a new User
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    // Get all Users
    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    // Get a single User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        Optional<User> User = userRepository.findById(id);
        if (User.isPresent()) {
            UserDto userDto = userMapper.toDto(User.get());
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a User
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = userMapper.partialUpdate(userDetails, user.get());
            User updatedUser = userRepository.save(existingUser);
            UserDto updatedUserDto = userMapper.toDto(updatedUser);
            return ResponseEntity.ok(updatedUserDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
