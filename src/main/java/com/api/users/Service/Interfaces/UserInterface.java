package com.api.users.Service.Interfaces;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    UserDto saveUser(UserEntity user);

    UserDto updateUser(String email, UserEntity user);

    Optional<UserEntity> findByEmail(String email);

    List<UserDto> getUsers();

    UserDto getUser(String email);

    void deleteUser(String email);

    void verifyEmail(String email);

}
