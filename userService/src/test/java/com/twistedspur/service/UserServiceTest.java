package com.twistedspur.service;

import com.twistedspur.dto.UserDto;
import com.twistedspur.mapper.UserMapper;
import com.twistedspur.mapper.UserMapperImpl;
import com.twistedspur.repository.UserRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Spy
    UserMapper userMapper;

    @Mock
    UserRepository userRepository;

    @Test
    void createUser() {
        var userDto = Instancio.create(UserDto.class);
        Mockito.doReturn(userMapper.toEntity(userDto)).when(userRepository).save(Mockito.any());

        userService.createUser(userDto);
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void attemptLogin() {
    }
}