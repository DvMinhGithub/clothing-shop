package com.example.demo.mapper;

import com.example.demo.enums.UserRole;
import com.example.demo.model.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    void setRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    RoleDto getRoleByName(@Param("roleName")UserRole userRole);
}
