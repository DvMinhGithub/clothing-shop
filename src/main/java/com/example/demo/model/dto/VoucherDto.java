package com.example.demo.model.dto;

import java.sql.Timestamp;

import com.example.demo.enums.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDto {
    private Long id;

    private String code;

    private String description;

    private Integer usedQuantity;

    private Integer totalQuantity;

    private DiscountType discountType;

    private Double discountLimit;

    private Timestamp startTime;

    private Timestamp endTime;

    private Double voucherCondition;
}
