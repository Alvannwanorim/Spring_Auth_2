package com.alvan.springauth.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alvan.springauth.config.JwtService;
import com.alvan.springauth.entity.Role;
import com.alvan.springauth.entity.User;
import com.alvan.springauth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    
public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(), 
            request.getPasswprd()
            )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    
    var jwtToken = jwtService.generateToken(user);
    
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    
}

public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPasswprd()))
                .role(Role.USER)
                .build();
        repository.save(user);

    
    var jwtToken = jwtService.generateToken(user);
    
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
}
    
}
