package com.api.users.Controllers;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.UserEntity;
import com.api.users.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> saveUser(UserEntity newUser) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(userService.saveUser(newUser));
    }

}
