package com.example.demo.controller;

import com.example.demo.model.dto.BrandDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.request.BrandRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Operation(summary = "Create brand", description = "Create brand")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping("/create")
    public ResponseEntity<ResponseApi<?>> createBrand(@RequestBody BrandRequest brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    @Operation(summary = "Get list brands", description = "Get list brands")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<List<BrandDto>>> getListCategories() {
        return brandService.getListBrands();
    }

    @Operation(summary = "Update brand", description = "Update brand")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseApi<?>> updateBrand(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        return brandService.updateBrand(id, brandRequest);
    }
}
