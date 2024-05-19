package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface UserService {
    ResponseEntity<ResponseApi<?>> updateProfile(Principal principal, UserRequest userRequest);

    ResponseEntity<ResponseApi<UserDto>> getProfile(Principal principal);
}
