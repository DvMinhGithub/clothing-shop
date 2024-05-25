package com.example.demo.mapper;

import com.example.demo.enums.UserRole;
import com.example.demo.model.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    void setRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    RoleDto getByName(@Param("roleName") UserRole userRole);

    void deleteUserRole(@Param("userId") Long userId);
}
