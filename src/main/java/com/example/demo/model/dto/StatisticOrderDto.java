package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticOrderDto {
    private Integer orderSuccess;

    private Integer totalOrder;

    private Integer orderCancel;

    private Integer orderPending;
}
