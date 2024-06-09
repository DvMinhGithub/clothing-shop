package com.example.demo.model.dto;

import com.example.demo.enums.Gender;
import com.example.demo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String address;

    private String avatar;

    private String dob;

    private String email;

    private Gender gender;

    private String name;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    private List<UserRole> listRole;
}
