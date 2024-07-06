package com.example.demo.mapper;

import com.example.demo.model.dto.RevenueByDayDto;
import com.example.demo.model.dto.RevenueByMonthDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RevenueMapper {
    List<RevenueByDayDto> getRevenueByDay(@Param("startDate")String startDate, @Param("endDate")String endDate);

    List<RevenueByDayDto> getRevenueByOrder();

    void updateRevenue(@Param("days") List<RevenueByDayDto> listRevenueByDayDto);

    void createDayForRevenue();

    Boolean isDuplicateDayForRevenue();

    List<RevenueByMonthDto> getRevenueByYear(@Param("year")String year);
}
