package com.example.demo.cronjob.task;

import com.example.demo.mapper.RevenueMapper;
import com.example.demo.model.dto.RevenueByDayDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RevenueTask {
    private final RevenueMapper revenueMapper;

    public RevenueTask(RevenueMapper revenueMapper) {
        this.revenueMapper = revenueMapper;
    }

    public void updateRevenue(){
        log.info("Start schedule task for updateRevenue");
        List<RevenueByDayDto> listRevenueByDayDto = revenueMapper.getRevenueByOrder();
        if(!listRevenueByDayDto.isEmpty()){
            revenueMapper.updateRevenue(listRevenueByDayDto);
        }
        log.info("End schedule task for updateRevenue");
    }

    public void createDayForRevenue(){
        log.info("Start schedule task for createDayForRevenue");
        if(!revenueMapper.isDuplicateDayForRevenue()){
            revenueMapper.createDayForRevenue();
        }
        log.info("End schedule task for createDayForRevenue");
    }
}
