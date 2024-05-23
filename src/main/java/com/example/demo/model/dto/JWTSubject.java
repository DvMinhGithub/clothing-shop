package com.example.demo.model.dto;

import com.example.demo.enums.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JWTSubject {
    private String email;

    private List<UserRole> roles;
}
