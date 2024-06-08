package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductBatchRequest {
    private Double importPrice;

    private Integer quantity;

    private Long productId;

    private Long supplierId;
}
