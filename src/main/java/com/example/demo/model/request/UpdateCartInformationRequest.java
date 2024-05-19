package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCartInformationRequest {
    private Long cartItemId;

    private Integer quantity;
}
