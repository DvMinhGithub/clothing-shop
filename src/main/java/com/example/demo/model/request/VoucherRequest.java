package com.example.demo.model.request;

import com.example.demo.enums.DiscountType;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class VoucherRequest {
    private String code;

    private String description;

    private Integer quantity;

    private DiscountType discountType;

    private Double discountLimit;

    private Integer totalQuantity;

    private Timestamp startTime;

    private Timestamp endTime;

    private Double condition;
}
