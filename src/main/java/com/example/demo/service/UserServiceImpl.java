package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final SecurityUtils securityUtils;

    private final UploadService uploadService;

    public UserServiceImpl(UserMapper userMapper, SecurityUtils securityUtils, UploadService uploadService) {
        this.userMapper = userMapper;
        this.securityUtils = securityUtils;
        this.uploadService = uploadService;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateProfile(UserRequest userRequest) {
        log.info("Start API: updateProfile with parameters: ({})", userRequest);
        try {
            Long userId = securityUtils.getUserLoggedInId();
            userRequest.setAvatar(uploadService.uploadFile(userRequest.getImage()));
            userMapper.updateProfile(userId, userRequest);
            log.info("End API: updateProfile");
            return new ResponseEntity<>(new ResponseApi<>("Update profile success"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: updateProfile with message {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<UserDto>> getProfile(Principal principal) {
        log.info("Start API: getProfile");
        UserDto userDto = userMapper.getByEmail(principal.getName());
        log.info("End API: getProfile");
        return new ResponseEntity<>(new ResponseApi<>("Get profile success", userDto), HttpStatus.OK);
    }
}
