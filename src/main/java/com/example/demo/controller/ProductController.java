package com.example.demo.controller;

import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.ChangeProductStatusRequest;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.RatingRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

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
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getListProducts
            (@RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
             @RequestParam(value = "categoryIds", required = false) String categoryIds,
             @RequestParam(value = "brandId", required = false) Long brandId) {
        return productService.getListProducts(name, page, limit, categoryIds, brandId);
    }

    @Operation(summary = "Get all products", description = "Get all products")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @GetMapping("/getAllProduct")
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getAllProducts
            (@RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
             @RequestParam(value = "categoryIds", required = false) String categoryIds,
             @RequestParam(value = "brandId", required = false) Long brandId) {
        return productService.getAllProducts(name, page, limit, categoryIds, brandId);
    }

    @Operation(summary = "Get product by id", description = "Get product by id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/detail/{id}")
    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Principal principal, @PathVariable Long id) {
        return productService.getProductById(principal, id);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping("/status/{id}")
    public ResponseEntity<ResponseApi<?>> changeProductStatus(@PathVariable("id") Long id, @RequestBody ChangeProductStatusRequest changeProductStatusRequest) {
        return productService.changeStatusProduct(id, changeProductStatusRequest);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @GetMapping("/top-sold")
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopSoldProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
            @RequestParam(value = "categoryIds", required = false) String categoryIds,
            @RequestParam(value = "brandId", required = false) Long brandId) {
        return productService.getTopSoldProduct(name, page, limit, categoryIds, brandId);
    }

    @Operation(summary = "Change product status", description = "Change product status")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @GetMapping("/top-view")
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopViewProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
            @RequestParam(value = "categoryIds", required = false) String categoryIds,
            @RequestParam(value = "brandId", required = false) Long brandId) {
        return productService.getTopViewProduct(name, page, limit, categoryIds, brandId);
    }

    @Operation(summary = "Rating product", description = "Rating")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @PostMapping("/rating")
    public ResponseEntity<ResponseApi<?>> changeProductStatus(Principal principal, @RequestBody RatingRequest ratingRequest) {
        return productService.ratingProduct(principal, ratingRequest);
    }
}
