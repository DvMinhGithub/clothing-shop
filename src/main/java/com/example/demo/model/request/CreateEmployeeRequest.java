package com.example.demo.model.request;

import com.example.demo.enums.Gender;
import com.example.demo.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEmployeeRequest {
    private String name;

    private String email;

    private String password;

    private UserRole role;

    private String phoneNumber;

    private String address;

    private Gender gender;

    private String dob;
}
