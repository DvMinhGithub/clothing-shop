package com.example.demo.model.request;

import com.example.demo.enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String name;

    private String phoneNumber;

    private String address;

    private Gender gender;

    private String dob;

    private String avatar;
}
