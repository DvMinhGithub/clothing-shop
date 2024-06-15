package com.example.demo.mapper;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void register(@Param("userInfo") UserDto userDto);

    UserDto getByEmail(@Param("email") String email);

    void updateProfile(@Param("userId") Long userId, @Param("userInfo") UserRequest userRequest);

    UserDto getById(@Param("userId") Long userId);

    void deleteById(@Param("userId") Long userId);

    List<UserDto> findEmployeeByName(@Param("employeeName") String employeeName);

    List<UserDto> findEmployee();

    Boolean existsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    Boolean existsByEmail(@Param("email") String email);

    Long getUserId(@Param("email") String userEmail);
}
