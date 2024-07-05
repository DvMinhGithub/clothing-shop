package com.example.demo.mapper;

import com.example.demo.model.dto.RevenueByDayDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RevenueMapper {
    List<RevenueByDayDto> getRevenueByDay();

    void updateRevenue(@Param("days") List<RevenueByDayDto> listRevenueByDayDto);

    void createDayForRevenue();

    Boolean isDuplicateDayForRevenue();
}
