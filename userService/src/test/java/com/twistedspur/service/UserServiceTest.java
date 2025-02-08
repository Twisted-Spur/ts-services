package com.twistedspur.service;

import com.twistedspur.dto.LoginDto;
import com.twistedspur.dto.UserDto;
import com.twistedspur.entity.User;
import com.twistedspur.mapper.UserMapperImpl;
import com.twistedspur.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Spy
    UserMapperImpl userMapperImpl;

    @Mock
    UserRepository userRepository;

    @Test
    void createUser_success() {
        var userDto = Instancio.create(UserDto.class);
        Mockito.doReturn(userMapperImpl.toEntity(userDto)).when(userRepository).save(Mockito.any());

        var userDtoResult = userService.createUser(userDto);
        Assertions.assertThat(userDtoResult.firstName()).isEqualTo(userDto.firstName());
    }

    @Test
    void getAllUsers_success() {
        var userDtos = Instancio.createList(UserDto.class);
        Mockito.doReturn(userMapperImpl.toEntities(userDtos)).when(userRepository).findAll();

        var userDtoResult = userService.getAllUsers();
        Assertions.assertThat(userDtoResult.size()).isEqualTo(userDtos.size());
    }

    @Test
    void getUserById_success() {
        var userDto = Instancio.create(UserDto.class);
        Mockito.doReturn(Optional.of(userMapperImpl.toEntity(userDto))).when(userRepository).findById(userDto.id());

        var userDtoResult = userService.getUserById(userDto.id());
        Assertions.assertThat(userDtoResult.firstName()).isEqualTo(userDto.firstName());
    }

    @Test
    void updateUser_success() {
        var userDto = Instancio.create(UserDto.class);
        Mockito.doReturn(Optional.of(userMapperImpl.toEntity(userDto))).when(userRepository).findById(userDto.id());

        var userDtoUpdate = Instancio.create(UserDto.class);
        Mockito.doReturn(userMapperImpl.toEntity(userDtoUpdate)).when(userRepository).save(Mockito.any());

        var userDtoResult = userService.updateUser(userDto.id(), userDtoUpdate);
        Assertions.assertThat(userDtoResult.firstName()).isEqualTo(userDtoUpdate.firstName());
    }

    @Test
    void deleteUser_success() {
        var userDto = Instancio.create(UserDto.class);
        Mockito.doReturn(Optional.of(userMapperImpl.toEntity(userDto))).when(userRepository).findById(userDto.id());
        Mockito.doNothing().when(userRepository).delete(Mockito.any(User.class));

        userService.deleteUser(userDto.id());
        Mockito.verify(userRepository, Mockito.times(1)).delete(Mockito.any(User.class));
    }

    @Test
    void attemptLogin_success() {
        // need to track the creation of the password, so can't use Instancio for UserDto
        var password = Instancio.create(String.class);
        // remember to encrypt the password because it would be encrypted in the DB already
        var encryptedPw = PasswordUtil.hashPassword(password);
        var userDto = new UserDto(1, "Joe", "Dirt", "joe.dirt@gmail.com", encryptedPw,
                false, LocalDate.of(1989, 9, 9), "111-222-3333",
                null, null);

        // pass in the unencrypted password
        var loginDto = new LoginDto(userDto.email(), password);
        Mockito.doReturn(Optional.of(userMapperImpl.toEntity(userDto))).when(userRepository).findByEmail(userDto.email());

        userService.attemptLogin(loginDto);
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(userDto.email());
    }
}