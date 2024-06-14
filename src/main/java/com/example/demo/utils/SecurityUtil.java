package com.example.demo.utils;

import com.example.demo.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
    private final UserMapper userMapper;

    public SecurityUtil(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Long getUserLoggedInId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return userMapper.getUserId(userName);
    }
}
