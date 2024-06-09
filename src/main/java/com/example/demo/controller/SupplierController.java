package com.example.demo.controller;

import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.SupplierService;
import com.github.pagehelper.PageInfo;
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
    public ResponseEntity<ResponseApi<PageInfo<SupplierDto>>> getListSuppliers
            (@RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit
            ) {
        return supplierService.getListSuppliers(name, page, limit);
    }

    @Operation(summary = "Update supplier", description = "Update supplier")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseApi<?>> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest supplierRequest) {
        return supplierService.updateSupplier(id, supplierRequest);
    }
}
