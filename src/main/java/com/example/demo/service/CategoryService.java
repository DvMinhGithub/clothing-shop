package com.example.demo.service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.request.CategoryRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<ResponseApi<?>> createCategory(CategoryRequest categoryRequest);

    ResponseEntity<ResponseApi<List<CategoryDto>>> getListCategories();

    ResponseEntity<ResponseApi<?>> updateCategory(Long id, CategoryRequest categoryRequest);
}
