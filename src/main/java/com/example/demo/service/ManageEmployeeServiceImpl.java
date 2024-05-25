package com.example.demo.service;

import com.example.demo.enums.UserRole;
import com.example.demo.exception.EmailExistException;
import com.example.demo.exception.PhoneNumberExistException;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.RoleDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ManageEmployeeServiceImpl implements ManageEmployeeService {
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final RoleMapper roleMapper;

    public ManageEmployeeServiceImpl(UserMapper userMapper, RoleMapper roleMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<UserDto>>> getListEmployee(String name, int page, int limit) {
        log.info("Start API: getListEmployee with parameters: (name: {}, page: {}, limit: {})", name, page, limit);
        PageHelper.startPage(page, limit);
        List<UserDto> listEmployee = name != null
                ? userMapper.findEmployeeByName(name)
                : userMapper.findEmployee();
        log.info("End API: getListEmployee");
        return new ResponseEntity<>(new ResponseApi<>("Get list employee success", new PageInfo<>(listEmployee)), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseApi<?>> createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        log.info("Start API: createEmployee with parameters: ({})", createEmployeeRequest);
        try {
            if (userMapper.existsByEmail(createEmployeeRequest.getEmail()))
                throw new EmailExistException(String.format("Email %s is already exist", createEmployeeRequest.getEmail()));

            if (userMapper.existsByPhoneNumber(createEmployeeRequest.getPhoneNumber()) != null)
                throw new PhoneNumberExistException(String.format("Phone number %s is already exist", createEmployeeRequest.getPhoneNumber()));

            UserDto user = UserDto.builder()
                    .dob(createEmployeeRequest.getDob())
                    .email(createEmployeeRequest.getEmail())
                    .address(createEmployeeRequest.getAddress())
                    .name(createEmployeeRequest.getName())
                    .gender(createEmployeeRequest.getGender())
                    .phoneNumber(createEmployeeRequest.getPhoneNumber())
                    .password(passwordEncoder.encode(createEmployeeRequest.getPassword()))
                    .build();
            userMapper.register(user);
            RoleDto roleDto = roleMapper.getByName(UserRole.EMPLOYEE);
            roleMapper.setRole(user.getId(), roleDto.getId());
            log.info("End API: createEmployee");
            return new ResponseEntity<>(new ResponseApi<>("Create employee success"), HttpStatus.CREATED);
        } catch (EmailExistException | PhoneNumberExistException e) {
            log.error("Error API: createEmployee with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseApi<?>> deleteEmployee(Long id) {
        log.info("Start API: deleteEmployee with parameters: (id: {})", id);
        roleMapper.deleteUserRole(id);
        userMapper.deleteById(id);
        log.info("End API: deleteEmployee");
        return new ResponseEntity<>(new ResponseApi<>("Delete employee success"), HttpStatus.OK);
    }
}
