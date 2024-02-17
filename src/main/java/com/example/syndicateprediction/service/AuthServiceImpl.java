package com.example.syndicateprediction.service;


import com.example.syndicateprediction.config.JwtService;
import com.example.syndicateprediction.entity.User;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.model.*;
import com.example.syndicateprediction.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (authRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new DefaultException("Email already exist", HttpStatus.BAD_REQUEST.value());
        }
        val user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        authRepository.save(user);
        val jwtToken = jwtService.generateToken(user);
        return RegisterResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
       val user= authRepository.findByEmail(loginRequest.getEmail());
       if(user.isEmpty()){
           throw new DefaultException("User not found with this email",404);
       }
       if(!passwordEncoder.matches(loginRequest.getPassword(),user.get().getPassword())){
           throw new DefaultException("Password is incorrect",HttpStatus.BAD_REQUEST.value());
       }
       authManager.authenticate(new UsernamePasswordAuthenticationToken(
               loginRequest.getEmail(),
               loginRequest.getPassword(),
               user.get().getAuthorities()
       ));
       val jwtToken=jwtService.generateToken(user.get());
        return LoginResponse.builder()
                .token(jwtToken)
                .user_id(user.get().getUser_id())
                .role(user.get().getRole().name())
                .email(user.get().getEmail())
                .name(user.get().getName())
                .build();
    }
}
