package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

import com.example.demo.enums.Gender;
import com.example.demo.enums.UserRole;

@Data
@Builder
public class CreateEmployeeRequest {
    private String name;

    private String email;

    private String password;

    private UserRole role = UserRole.EMPLOYEE;

    private String phoneNumber;

    private String address;

    private Gender gender;

    private Timestamp dob;
}
