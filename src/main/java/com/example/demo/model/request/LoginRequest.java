package com.example.demo.model.request;

import lombok.*;

@Data
@Builder
public class LoginRequest {
    private String email;

    private String password;
}
