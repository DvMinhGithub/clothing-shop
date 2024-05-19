package com.example.demo.authentication;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailsServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            UserDto user = userMapper.getUserByEmail(email);
            System.out.println(user);
            if (user == null) {
                throw new UsernameNotFoundException(email);
            }
            return new CustomUserDetail(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
