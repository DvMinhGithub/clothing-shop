package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequest {
    private Long productId;

    private String startTime;

    private String endTime;

    private Double discountPrice;

    private Boolean isActive;
}
