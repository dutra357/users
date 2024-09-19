package com.api.users.Service.Interfaces;

import com.api.users.Entities.UserEntity;

import java.util.Optional;

public interface UserInterface {

    Optional<UserEntity> findByEmail(String email);
}
