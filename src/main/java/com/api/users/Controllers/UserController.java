package com.api.users.Controllers;

import com.api.users.DataTransfer.UserDto;
import com.api.users.Entities.UserEntity;
import com.api.users.Service.Interfaces.UserInterface;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    //private UsuarioRepository repository;
    //private final AuthenticationManager authenticationManager;
    //private final JwtUtil tokenService;

    private final UserInterface userService;
    public UserController(UserInterface userService) {
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody LoginDtoRequest login){
//        var usernamePassword = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//
//        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());
//
//        return ResponseEntity.ok(new DtoTokenResponse(token));
//    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody  UserEntity newUser) {
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(userService.saveUser(newUser));
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam("email")  String email) {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(userService.getUser(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable  String email) {
        userService.deleteUser(email);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
