package com.example.demo.model.dto;

import java.sql.Timestamp;

import com.example.demo.enums.DiscountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoucherDto {
    private Long id;

    private String code;

    private String description;

    private Integer used_quantity;

    private Integer total_quantity;

    private DiscountType discountType;

    private Double discountLimit;

    private Timestamp startTime;

    private Timestamp endTime;

    private Double condition;
}
