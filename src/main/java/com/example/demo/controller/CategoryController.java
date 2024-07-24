package com.example.demo.controller;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.request.CategoryRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create category", description = "Create category")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping("/create")
    public ResponseEntity<ResponseApi<?>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }

    @Operation(summary = "Get list categories", description = "Get list categories")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<List<CategoryDto>>> getListCategories() {
        return categoryService.getListCategories();
    }

    @Operation(summary = "Update category", description = "Update category")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseApi<?>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }
}
