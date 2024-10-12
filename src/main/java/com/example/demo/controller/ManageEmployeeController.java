package com.example.demo.controller;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.ManageEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class ManageEmployeeController {
    private final ManageEmployeeService manageEmployeeService;

    public ManageEmployeeController(ManageEmployeeService manageEmployeeService) {
        this.manageEmployeeService = manageEmployeeService;
    }

    @Operation(summary = "Get list employee", description = "Get list employee")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("ADMIN")
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<CustomPageable<UserDto>>> getListEmployee(String name, PageRequest pageRequest) {
        return manageEmployeeService.getListEmployee(name, pageRequest);
    }

    @Operation(summary = "Create employee", description = "Create employee")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("ADMIN")
    @PostMapping("/create")
    public ResponseEntity<ResponseApi<?>> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return manageEmployeeService.createEmployee(createEmployeeRequest);
    }

    @Operation(summary = "Delete employee", description = "Delete employee")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseApi<?>> deleteEmployee(@PathVariable Long id) {
        return manageEmployeeService.deleteEmployee(id);
    }
}
