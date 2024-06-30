package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RevenueFilter {
    private String startTime;

    private String endTime;

    //day, month
    private String type;
}
