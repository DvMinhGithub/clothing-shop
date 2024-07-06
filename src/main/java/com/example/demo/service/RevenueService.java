package com.example.demo.service;

import com.example.demo.model.dto.RevenueByDayDto;
import com.example.demo.model.dto.RevenueByMonthDto;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RevenueService {
    ResponseEntity<ResponseApi<List<RevenueByDayDto>>> getRevenueByWeek(String startDate, String endDate);

    ResponseEntity<ResponseApi<List<RevenueByMonthDto>>> getRevenueByYear(String year);
}
