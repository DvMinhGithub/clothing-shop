package com.example.demo.service;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface ManageEmployeeService {
    ResponseEntity<ResponseApi<CustomPageable<UserDto>>> getListEmployee(String name, PageRequest pageRequest);

    ResponseEntity<ResponseApi<?>> createEmployee(CreateEmployeeRequest createEmployeeRequest);

    ResponseEntity<ResponseApi<?>> deleteEmployee(Long id);
}
