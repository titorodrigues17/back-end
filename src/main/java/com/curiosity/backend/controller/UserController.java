package com.curiosity.backend.controller;

import com.curiosity.backend.dto.ApiResponse;
import com.curiosity.backend.dto.ResponseFailed;
import com.curiosity.backend.model.User;
import com.curiosity.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Object saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        ResponseFailed responseFailed = new ResponseFailed("Error al crear el usuario", "USER_CREATION_FAILED");
        if (savedUser != null) {
            return new ApiResponse<>(true, "Usuario creado con éxito", savedUser);
        } else {
            return new ApiResponse<>(false, "Error al crear el usuario", responseFailed);
        }
    }

    @PostMapping("/sign-in")
    public Object authenticateUser(@RequestBody User credentials) {
        ResponseFailed responseFailed = new ResponseFailed("Credenciales incorrectas", "AUTHENTICATION_FAILED");
        User user = userService.getUserByAuthentication(credentials.getEmail(), credentials.getPassword());
        if (user != null) {
            return new ApiResponse<>(true, "Usuario autenticado con éxito", user);
        } else {
            return new ApiResponse<>(false, "Credenciales incorrectas", responseFailed);
        }
    }

}
