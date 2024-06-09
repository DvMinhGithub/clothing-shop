package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionRequest {
    private Long productId;

    private String startTime;

    private String endTime;

    private Double discountPrice;
}
