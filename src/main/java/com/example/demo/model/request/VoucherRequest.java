package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class VoucherRequest {
    private String code;

    private String description;

    private Integer quantity;

    private Double discountPrice;

    private Integer totalQuantity;

    private Timestamp startTime;

    private Timestamp endTime;

    private Double condition;
}
