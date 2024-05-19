package com.example.demo.service;

import com.example.demo.model.dto.BrandDto;
import com.example.demo.model.request.BrandRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    ResponseEntity<ResponseApi<?>> createBrand(BrandRequest brandRequest);

    ResponseEntity<ResponseApi<List<BrandDto>>> getListBrands();

    ResponseEntity<ResponseApi<?>> updateBrand(Long id, BrandRequest brandRequest);
}
