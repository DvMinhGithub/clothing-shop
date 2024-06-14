package com.example.demo.service;

import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.RatingRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ProductService {
    ResponseEntity<ResponseApi<?>> createProduct(ProductRequest productRequest);

    ResponseEntity<ResponseApi<?>> updateProduct(Long id, ProductRequest productRequest) throws IOException;

    ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getListProducts(String name, int page, int limit, String categoryIds, Long brandId);

    ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id);

    ResponseEntity<ResponseApi<?>> deleteProduct(Long id);

    ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopSoldProduct(String name, int page, int limit, String categoryIds, Long brandId);

    ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopViewProduct(String name, int page, int limit, String categoryIds, Long brandId);

    ResponseEntity<ResponseApi<?>> ratingProduct(RatingRequest ratingRequest);
}
