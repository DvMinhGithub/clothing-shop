package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDto {
    private Long id;

    private String productImage;

    private String productName;

    private Timestamp endTime;

    private Timestamp startTime;

    private Double discountPrice;

    private Boolean isActive;
}
