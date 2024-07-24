package com.example.demo.controller;

import com.example.demo.model.dto.RevenueByDayDto;
import com.example.demo.model.dto.RevenueByMonthDto;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.RevenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenue")
@CrossOrigin(origins = "*")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @Operation(summary = "Get revenue by week", description = "Get revenue by week")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("ADMIN")
    @GetMapping("/get-by-week")
    public ResponseEntity<ResponseApi<List<RevenueByDayDto>>> getRevenueByWeek(@RequestParam(name = "startDate")String startDate,
                                                                               @RequestParam(name = "endDate")String endDate) {
        return revenueService.getRevenueByWeek(startDate, endDate);
    }

    @Operation(summary = "Get revenue by year", description = "Get revenue by year")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("ADMIN")
    @GetMapping("/get-by-year")
    public ResponseEntity<ResponseApi<List<RevenueByMonthDto>>> getRevenueByYear(@RequestParam(name = "year")String year) {
        return revenueService.getRevenueByYear(year);
    }
}
