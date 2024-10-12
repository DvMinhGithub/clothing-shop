package com.example.demo.controller;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductFilterRequest;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.RatingRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create product", description = "Create product")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseApi<?>> createProduct(@ModelAttribute ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @Operation(summary = "Update product", description = "Update product")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseApi<?>> updateProduct(@PathVariable Long id, @ModelAttribute ProductRequest productRequest) throws IOException {
        return productService.updateProduct(id, productRequest);
    }

    @Operation(summary = "Get list products", description = "Get list products")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/getListProduct")
    public ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getListProducts(PageRequest pageRequest, ProductFilterRequest productFilterRequest) {
        return productService.getListProducts(pageRequest, productFilterRequest);
    }

    @Operation(summary = "Get product by id", description = "Get product by id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/detail/{id}")
    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseApi<?>> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/top-sold")
    public ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getTopSoldProduct(
            PageRequest pageRequest, ProductFilterRequest productFilterRequest) {
        return productService.getTopSoldProduct(pageRequest, productFilterRequest);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/top-view")
    public ResponseEntity<ResponseApi<CustomPageable<ProductDto>>> getTopViewProduct(
            PageRequest pageRequest, ProductFilterRequest productFilterRequest) {
        return productService.getTopViewProduct(pageRequest, productFilterRequest);
    }

    @Operation(summary = "Rating product", description = "Rating")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @PostMapping("/rating")
    public ResponseEntity<ResponseApi<?>> changeProductStatus(@RequestBody RatingRequest ratingRequest) {
        return productService.ratingProduct(ratingRequest);
    }
}
