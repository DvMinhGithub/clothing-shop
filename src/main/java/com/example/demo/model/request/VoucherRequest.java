package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class VoucherRequest {
    private String code;

    private String description;

    private Integer quantity;

    private Double discountPrice;

    private Integer totalQuantity;

    private String startTime;

    private String endTime;

    private Double condition;

    private Boolean isActive;
}
