package com.example.demo.model.request;

import com.example.demo.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

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
