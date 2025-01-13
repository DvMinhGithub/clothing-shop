package com.example.demo.controller;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Operation(summary = "Add supplier", description = "Add supplier")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseApi<?>> addSupplier(@RequestBody SupplierRequest supplierRequest) {
        return supplierService.addSupplier(supplierRequest);
    }

    @Operation(summary = "Get list suppliers", description = "Get list suppliers")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<CustomPageable<SupplierDto>>> getListSuppliers(String name, PageRequest pageRequest) {
        return supplierService.getListSuppliers(name, pageRequest);
    }

    @Operation(summary = "Update supplier", description = "Update supplier")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseApi<?>> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest supplierRequest) {
        return supplierService.updateSupplier(id, supplierRequest);
    }

    @Operation(summary = "Delete supplier", description = "Delete supplier")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseApi<?>> deleteSupplier(@PathVariable(name = "id") Long supplierId) {
        return supplierService.deleteSupplier(supplierId);
    }
}
