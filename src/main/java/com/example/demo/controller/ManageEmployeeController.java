package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.ManageEmployeeService;

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
    public ResponseEntity<ResponseApi<PageInfo<UserDto>>> getListEmployee(@RequestParam(value = "name", required = false) String name,
                                                                          @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                                          @RequestParam(value = "limit", defaultValue = "20", required = false) int limit) {
        return manageEmployeeService.getListEmployee(name, page, limit);
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
