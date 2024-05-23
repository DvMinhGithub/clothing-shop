package com.example.demo.model.dto;

import com.example.demo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
