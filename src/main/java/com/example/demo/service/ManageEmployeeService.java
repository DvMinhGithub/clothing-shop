package com.example.demo.service;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

public interface ManageEmployeeService {
    ResponseEntity<ResponseApi<PageInfo<UserDto>>> getListEmployee(String name, int page, int limit);

    ResponseEntity<ResponseApi<?>> createEmployee(CreateEmployeeRequest createEmployeeRequest);

    ResponseEntity<ResponseApi<?>> deleteEmployee(Long id);
}
