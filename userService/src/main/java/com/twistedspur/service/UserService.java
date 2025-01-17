package com.twistedspur.service;

import com.twistedspur.dto.LoginRequest;
import com.twistedspur.dto.UserDto;
import com.twistedspur.entity.User;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.exception.UserValidationException;
import com.twistedspur.mapper.UserMapper;
import com.twistedspur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    // Create a new User
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserValidationException("Sorry, an account with that email already exists.");
        }

        // need to secure the password before db storage
        user.setPasswd(PasswordUtil.hashPassword(user.getPasswd()));

        userRepository.save(user);
        return userMapper.toDto(user);
    }

    // Get all Users
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    // Get a single User by ID
    public UserDto getUserById(Integer id) {
        Optional<User> User = userRepository.findById(id);
        if (User.isPresent()) {
            return userMapper.toDto(User.get());
        } else {
            throw new NotFoundException("User with id " + id + " not found");
        }
    }

    // Update a User
    public UserDto updateUser(Integer id, UserDto userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = userMapper.partialUpdate(userDetails, user.get());

            // need to secure the password before db storage
            existingUser.setPasswd(PasswordUtil.hashPassword(existingUser.getPasswd()));

            User updatedUser = userRepository.save(existingUser);
            return userMapper.toDto(updatedUser);
        } else {
            throw new NotFoundException("User with id " + id + " not found");
        }
    }

    // Delete a User
    public void deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new NotFoundException("User with id " + id + " not found");
        }
    }

    // Validate login attempt
    public void attemptLogin(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()) {
            // now validate provided password
            if (!PasswordUtil.verifyPassword(loginRequest.password(), user.get().getPasswd())) {
                throw new UserValidationException("Invalid password provided for this account.");
            }
        } else {
            throw new NotFoundException("User with email " + loginRequest.email() + " not found");
        }
    }
}
