package com.example.demo.model.request;

import com.example.demo.enums.Gender;
import com.example.demo.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not incorrect")
    private String email;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be 6 characters or more")
    @Size(max = 16, message = "Password must be less than 16 characters")
    private String password;

    private UserRole role;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Invalid phone number")
    private String phoneNumber;

    private String address;

    private Gender gender;

    private String dob;

    private String OTP;
}
