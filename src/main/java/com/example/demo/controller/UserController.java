package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Update user", description = "Update user")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN", "CUSTOMER"})
    @PutMapping("/update")
    public ResponseEntity<ResponseApi<?>> updateProfile(@ModelAttribute UserRequest userRequest) {
        return userService.updateProfile(userRequest);
    }

    @Operation(summary = "Get user", description = "Get user")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN", "CUSTOMER"})
    @GetMapping("/getProfile")
    public ResponseEntity<ResponseApi<UserDto>> getUser(Principal principal) {
        return userService.getProfile(principal);
    }
}
