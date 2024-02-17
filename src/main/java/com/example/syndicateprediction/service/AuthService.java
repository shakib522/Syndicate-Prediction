package com.example.syndicateprediction.service;

import com.example.syndicateprediction.model.LoginRequest;
import com.example.syndicateprediction.model.LoginResponse;
import com.example.syndicateprediction.model.RegisterRequest;
import com.example.syndicateprediction.model.RegisterResponse;

public interface AuthService {

     RegisterResponse register(RegisterRequest registerRequest);
     LoginResponse login(LoginRequest loginRequest);

}
