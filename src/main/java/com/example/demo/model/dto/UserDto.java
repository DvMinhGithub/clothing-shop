package com.example.demo.model.dto;

import com.example.demo.enums.Gender;
import com.example.demo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;

    private String address;

    private String avatar;

    private Timestamp dob;

    private String email;

    private Gender gender;

    private String name;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    private List<UserRole> listRole;
}
