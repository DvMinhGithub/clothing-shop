//package com.example.demo.service;
//
//import com.example.demo.model.dto.ProductDetailDto;
//import com.example.demo.model.dto.ProductDto;
//import com.example.demo.model.request.ChangeProductStatusRequest;
//import com.example.demo.model.request.ProductRequest;
//import com.example.demo.model.response.ResponseApi;
//import org.springframework.http.ResponseEntity;
//
//import java.io.IOException;
//
//public interface ProductService {
//    ResponseEntity<ResponseApi<?>> createProduct(ProductRequest productRequest);
//
//    ResponseEntity<ResponseApi<?>> updateProduct(Long id, ProductRequest productRequest) throws IOException;
//
//    ResponseEntity<ResponseApi<Page<ProductDto>>> getListProducts(String name, int page, int limit, String categoryIds, Long brandId);
//
//    ResponseEntity<ResponseApi<Page<ProductDto>>> getAllProducts(String name, int page, int limit, String categoryIds, Long brandId);
//
//    ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id);
//
//    ResponseEntity<ResponseApi<?>> changeStatusProduct(Long id, ChangeProductStatusRequest changeProductStatusRequest);
//
//    ResponseEntity<ResponseApi<Page<ProductDto>>> getTopSellersProducts(int page, int limit);
//
//    ResponseEntity<ResponseApi<Page<ProductDto>>> getTopViewedProducts(int page, int limit)
//}
