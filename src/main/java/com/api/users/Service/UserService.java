package com.api.users.Service;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.Address;
import com.api.users.Entities.UserEntity;
import com.api.users.Repository.AddressRepository;
import com.api.users.Repository.UserRepository;
import com.api.users.Service.Interfaces.UserInterface;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public UserDto saveUser(UserEntity user) {
        verifyEmail(user.getEmail());

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new UserDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(String email, UserEntity user) {
        verifyEmail(user.getEmail());

        UserEntity userUpdate = userRepository.findByEmail(email).get();

        if (user.getPassword() != null) {
            userUpdate.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }

        if (user.getEmail() != null) {
            userUpdate.setEmail(user.getEmail());
        }

        if (user.getName() != null) {
            userUpdate.setEmail(user.getName());
        }

        return new UserDto(userRepository.save(userUpdate));
    }

    @Override
    public UserDto getUser(String email) {
        Optional<UserEntity> user = findByEmail(email);
        return new UserDto(user.get());
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(toList());
    }

    @Override
    public void deleteUser(String email) {
        findByEmail(email);
        userRepository.deleteByEmail(email);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Address addressUpdate = addressRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found.")
        );

        if (address.getCep() != null) {
            addressUpdate.setCep(address.getCep());
        }

        if (address.getCity() != null) {
            addressUpdate.setCity(address.getCity());
        }

        if (address.getComplement() != null) {
            addressUpdate.setComplement(address.getComplement());
        }

        if (address.getRoad() != null) {
            addressUpdate.setRoad(address.getRoad());
        }

        if (address.getState() != null) {
            addressUpdate.setState(address.getState());
        }

        if (address.getNumber() != null) {
            addressUpdate.setNumber(address.getNumber());
        }

        return addressRepository.save(addressUpdate);
    }



    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.of(userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "E-mail not fund.")));
    }

    @Override
    public void verifyEmail(String email) {
        if(findByEmail(email).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "E-mail already exists."
            );
        }
    }

}
