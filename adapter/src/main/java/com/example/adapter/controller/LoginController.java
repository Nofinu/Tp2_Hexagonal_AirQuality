package com.example.adapter.controller;

import com.example.adapter.dto.UserCreateDto;
import org.example.spi.adapter.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody UserCreateDto userCreateDto){

    }
}
