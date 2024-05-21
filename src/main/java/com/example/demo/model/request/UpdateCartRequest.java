package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCartRequest {
    private Long cartItemId;

    private Integer quantity;
}
