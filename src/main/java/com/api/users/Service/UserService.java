package com.api.users.Service;

import com.api.users.Entities.UserEntity;
import com.api.users.Repository.UserRepository;
import com.api.users.Service.Interfaces.UserInterface;

import java.util.Optional;

public class UserService implements UserInterface {

    public final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
