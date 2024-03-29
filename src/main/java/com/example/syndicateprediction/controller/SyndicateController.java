package com.example.syndicateprediction.controller;


import com.example.syndicateprediction.model.LoginRequest;
import com.example.syndicateprediction.model.LoginResponse;
import com.example.syndicateprediction.model.RegisterRequest;
import com.example.syndicateprediction.model.RegisterResponse;
import com.example.syndicateprediction.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class SyndicateController {

    private final AuthService authService;

    @GetMapping("/welcome")
    public String welcome() {

        val day=LocalDateTime.now().getDayOfMonth();
        val month=LocalDateTime.now().getMonthValue();
        val year=LocalDateTime.now().getYear();

        return "Welcome to Syndicate Prediction System "+ month+" "+day+" "+year;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.status(201).body(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(200).body(authService.login(loginRequest));
    }
}
