package com.example.demo.mapper;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.RegisterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void register(@Param("userInfo")UserDto userDto);

    UserDto getUserByEmail(@Param("email") String email);

    UserDto getUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
