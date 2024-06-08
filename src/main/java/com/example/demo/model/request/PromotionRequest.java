package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class PromotionRequest {
    private Long productId;

    private Timestamp startTime;

    private Timestamp endTime;

    private Double discountPrice;
}
