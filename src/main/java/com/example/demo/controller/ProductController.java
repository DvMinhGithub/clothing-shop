//package com.example.demo.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//import com.example.demo.model.dto.ProductDetailDto;
//import com.example.demo.model.dto.ProductDto;
//import com.example.demo.model.request.ChangeProductStatusRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.model.request.ProductRequest;
//import com.example.demo.service.ProductService;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Operation(summary = "Create product", description = "Create product")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PostMapping(value = "/create")
//    public ResponseEntity<ResponseApi<?>> createProduct(@ModelAttribute ProductRequest productRequest) throws IOException {
//        return productService.createProduct(productRequest);
//    }
//
//    @Operation(summary = "Update product", description = "Update product")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PutMapping(value = "/update/{id}")
//    public ResponseEntity<ResponseApi<?>> updateProduct(@PathVariable Long id, @ModelAttribute ProductRequest productRequest) throws IOException {
//        return productService.updateProduct(id, productRequest);
//    }
//
//    @Operation(summary = "Get list products", description = "Get list products")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @GetMapping("/getListProduct")
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getListProducts
//            (@RequestParam(value = "name", required = false) String name,
//             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
//             @RequestParam(value = "categoryIds", required = false) String categoryIds,
//             @RequestParam(value = "brandId", required = false) Long brandId) {
//        return productService.getListProducts(name, page, limit, categoryIds, brandId);
//    }
//
//    @Operation(summary = "Get all products", description = "Get all products")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @GetMapping("/getAllProduct")
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getAllProducts
//            (@RequestParam(value = "name", required = false) String name,
//             @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit,
//             @RequestParam(value = "categoryIds", required = false) String categoryIds,
//             @RequestParam(value = "brandId", required = false) Long brandId) {
//        return productService.getAllProducts(name, page, limit, categoryIds, brandId);
//    }
//
//    @Operation(summary = "Get product by id", description = "Get product by id")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @GetMapping("/detail/{id}")
//    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
//    @Operation(summary = "Change product status", description = "Change product status")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PutMapping("/status/{id}")
//    public ResponseEntity<ResponseApi<?>> changeProductStatus(@PathVariable("id") Long id, @RequestBody ChangeProductStatusRequest changeProductStatusRequest) {
//        return productService.changeStatusProduct(id, changeProductStatusRequest);
//    }
//
//    @Operation(summary = "Change product status", description = "Change product status")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured("CUSTOMER")
//    @GetMapping("/top-sellers")
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getTopSellersProducts(
//            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//            @RequestParam(value = "limit", defaultValue = "5", required = false) int limit) {
//        return productService.getTopSellersProducts(page, limit);
//    }
//
//    @Operation(summary = "Change product status", description = "Change product status")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured("CUSTOMER")
//    @GetMapping("/top-viewed")
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getTopViewedProducts(
//            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//            @RequestParam(value = "limit", defaultValue = "5", required = false) int limit) {
//        return productService.getTopViewedProducts(page, limit);
//    }
//}
