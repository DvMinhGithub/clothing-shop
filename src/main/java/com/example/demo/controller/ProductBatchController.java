package com.example.demo.controller;

import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.ProductBatchRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.ProductBatchService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-batch")
@CrossOrigin
public class ProductBatchController {
    private final ProductBatchService productBatchService;

    public ProductBatchController(ProductBatchService productBatchService) {
        this.productBatchService = productBatchService;
    }

    @Operation(summary = "Create product batch", description = "Create product batch")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseApi<?>> createProductBatch(@RequestBody ProductBatchRequest productBatchRequest) {
        return productBatchService.createProductBatch(productBatchRequest);
    }

    @Operation(summary = "Get list product batch", description = "Get list product batch")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<PageInfo<ProductBatchDto>>> getListProductBatch
            (@RequestParam(value = "page", defaultValue = "0", required = false) int page,
             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit) {
        return productBatchService.getListProductBatch(page, limit);
    }

}
