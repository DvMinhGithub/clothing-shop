package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingRequest {
    private Long productId;

    private Integer rating;
}
