package com.api.users.Service;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.UserEntity;
import com.api.users.Repository.UserRepository;
import com.api.users.Service.Interfaces.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto saveUser(UserEntity user) {
        return new UserDto(userRepository.save(user));
    }


    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(toList());
    }
}
