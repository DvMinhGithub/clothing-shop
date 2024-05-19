package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

import com.example.demo.enums.Gender;

@Data
@Builder
public class EmployeeDto {
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private Gender gender;

    private Timestamp dob;

    private String avatar;
}
