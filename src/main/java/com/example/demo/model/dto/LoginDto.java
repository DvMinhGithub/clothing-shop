package com.example.demo.model.dto;

import lombok.*;

@Data
@Builder
public class LoginDto {
    private String accessToken;

    private String refreshToken;
}
