package com.example.demo.utils;

import com.example.demo.enums.UserRole;
import com.example.demo.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityUtils {
    private final UserMapper userMapper;

    public SecurityUtils(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Long getUserLoggedInId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return userMapper.getUserId(userName);
    }

    public List<UserRole> getUserLoggedInRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .map(authority -> UserRole.valueOf(authority.getAuthority()))
                .toList();
    }
}
