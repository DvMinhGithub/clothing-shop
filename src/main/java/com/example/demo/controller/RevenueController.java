package com.example.demo.controller;

import com.example.demo.mapper.RevenueMapper;
import com.example.demo.model.request.PromotionRequest;
import com.example.demo.model.response.ResponseApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
public class RevenueController {
    private final RevenueMapper revenueMapper;

    public RevenueController(RevenueMapper revenueMapper) {
        this.revenueMapper = revenueMapper;
    }

//    @Operation(summary = "Get revenue by week", description = "Get revenue by week")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @GetMapping
//    public ResponseEntity<ResponseApi<?>> getRevenueByWeek(@RequestParam) {
//        return promotionService.updatePromotionStatus(id, promotionRequest);
//    }
}
