package com.example.demo.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.AuthService;
import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.request.*;
import com.example.demo.model.response.ResponseApi;

@RestController
@RequestMapping("/")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register", description = "Register")
    @PostMapping("/register")
    public ResponseEntity<ResponseApi<?>> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Operation(summary = "Login", description = "Login")
    @PostMapping("/login")
    public ResponseEntity<ResponseApi<LoginDto>> login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @Operation(summary = "Verify user account", description = "Verify user account")
    @PostMapping("/verifyUserAccount")
    public ResponseEntity<ResponseApi<?>> verifyUserAccount(@RequestBody RegisterRequest registerRequest) {
        return authService.verifyUserAccount(registerRequest);
    }

    @PostMapping("/getWebhookRequest")
    public ResponseEntity<?> getWebhookRequest(@RequestBody WebhookRequest webhookRequest) {
        System.out.println(webhookRequest);
        return ResponseEntity.ok("Done");
    }

    @Operation(summary = "Test api", description = "Test api")
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Thành công");
    }

    @Operation(summary = "Test api", description = "Test api")
    @PostMapping("/test")
    public ResponseEntity<?> test(@ModelAttribute TestRequest testRequest) {
        System.out.println(testRequest);
        return ResponseEntity.ok("Thành công");
    }
}
