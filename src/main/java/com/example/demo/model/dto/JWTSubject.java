package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

import com.example.demo.enums.UserRole;

@Data
@Builder
public class JWTSubject {
    private String email;

    private List<UserRole> roles;
}
