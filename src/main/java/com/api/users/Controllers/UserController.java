package com.api.users.Controllers;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.Address;
import com.api.users.Entities.UserEntity;
import com.api.users.Service.Interfaces.UserInterface;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserInterface userService;
    public UserController(UserInterface userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody  UserEntity newUser) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(userService.saveUser(newUser));
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam("email")  String email) {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(userService.getUser(email));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(userService.getUsers());
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable  String email, @RequestBody  UserEntity newUser) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(userService.updateUser(email, newUser));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable  String email) {
        userService.deleteUser(email);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressUpdate) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(userService.updateAddress(id, addressUpdate));
    }

}
