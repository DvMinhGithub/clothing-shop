package com.example.demo.controller;

import com.example.demo.model.dto.PromotionDto;
import com.example.demo.model.request.PromotionRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.PromotionService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
@CrossOrigin
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Operation(summary = "Create promotion", description = "Create promotion")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseApi<?>> createPromotion(@RequestBody PromotionRequest promotionRequest) {
        return promotionService.createPromotion(promotionRequest);
    }

    @Operation(summary = "Get list promotions", description = "Get list promotions")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @GetMapping("/get")
    public ResponseEntity<ResponseApi<PageInfo<PromotionDto>>> getListPromotions
            (@RequestParam(value = "page", defaultValue = "0", required = false) int page,
             @RequestParam(value = "limit", defaultValue = "20", required = false) int limit) {
        return promotionService.getListPromotions(page, limit);
    }

    @Operation(summary = "Update promotion", description = "Update promotion")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseApi<?>> updatePromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
        return promotionService.updatePromotion(id, promotionRequest);
    }

    @Operation(summary = "Update promotion status", description = "Update promotion status")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PutMapping(value = "/update/status/{id}")
    public ResponseEntity<ResponseApi<?>> updatePromotionStatus(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
        return promotionService.updatePromotionStatus(id, promotionRequest);
    }
}
