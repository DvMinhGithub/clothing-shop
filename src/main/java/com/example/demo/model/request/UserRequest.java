package com.example.demo.model.request;

import java.sql.Timestamp;

import com.example.demo.enums.Gender;
import lombok.*;

@Data
@Builder
public class UserRequest {

    private String name;

    private String phoneNumber;

    private String address;

    private Gender gender;

    private Timestamp dob;

    private String avatar;
}
