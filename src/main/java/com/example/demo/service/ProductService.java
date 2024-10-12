package com.example.demo.service;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductFilterRequest;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.RatingRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ProductService {
    ResponseEntity<ResponseApi<?>> createProduct(ProductRequest productRequest);

    ResponseEntity<ResponseApi<?>> updateProduct(Long id, ProductRequest productRequest) throws IOException;

    ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getListProducts(PageRequest pageRequest, ProductFilterRequest productFilterRequest);

    ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id);

    ResponseEntity<ResponseApi<?>> deleteProduct(Long id);

    ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getTopSoldProduct(PageRequest pageRequest, ProductFilterRequest productFilterRequest);

    ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getTopViewProduct(PageRequest pageRequest, ProductFilterRequest productFilterRequest);

    ResponseEntity<ResponseApi<?>> ratingProduct(RatingRequest ratingRequest);
}
