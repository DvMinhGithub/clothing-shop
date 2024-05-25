package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseEntity<ResponseApi<?>> updateProfile(Principal principal, UserRequest userRequest) {
        log.info("Start API: updateProfile with parameters: ({})", userRequest);
        try {
            UserDto userDto = userMapper.getByEmail(principal.getName());
            userMapper.updateProfile(userDto.getId(), userRequest);
            log.info("End API: updateProfile");
            return new ResponseEntity<>(new ResponseApi<>("Update profile success"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: updateProfile with message {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseApi<UserDto>> getProfile(Principal principal) {
        log.info("Start API: getProfile");
        UserDto userDto = userMapper.getByEmail(principal.getName());
        log.info("End API: getProfile");
        return new ResponseEntity<>(new ResponseApi<>("Get profile success", userDto), HttpStatus.OK);
    }
}
