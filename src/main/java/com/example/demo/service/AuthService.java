package com.example.demo.service;

import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RegisterRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<ResponseApi<?>> register(RegisterRequest registerRequest);

    ResponseEntity<ResponseApi<LoginDto>> login(LoginRequest loginRequest);

    ResponseEntity<ResponseApi<?>> verifyUserAccount(RegisterRequest registerRequest);
}
