package com.example.demo.service;

import com.example.demo.mapper.RevenueMapper;
import com.example.demo.model.dto.RevenueByDayDto;
import com.example.demo.model.dto.RevenueByMonthDto;
import com.example.demo.model.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RevenueServiceImpl implements RevenueService{
    private final RevenueMapper revenueMapper;

    public RevenueServiceImpl(RevenueMapper revenueMapper) {
        this.revenueMapper = revenueMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<List<RevenueByDayDto>>> getRevenueByWeek(String startDate, String endDate){
        log.info("Start API: getRevenueByWeek with parameters: ({}, {})", startDate, endDate);
        List<RevenueByDayDto> listRevenueByDayDto = revenueMapper.getRevenueByDay(startDate, endDate);
        log.info("End API: getRevenueByWeek");
        return new ResponseEntity<>(new ResponseApi<>("Get revenue by week success", listRevenueByDayDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<List<RevenueByMonthDto>>> getRevenueByYear(String year){
        log.info("Start API: getRevenueByYear with parameters: ({})", year);
        List<RevenueByMonthDto> listRevenueByMonthDto = revenueMapper.getRevenueByYear(year);
        log.info("End API: getRevenueByYear");
        return new ResponseEntity<>(new ResponseApi<>("Get revenue by year success", listRevenueByMonthDto), HttpStatus.OK);
    }
}
