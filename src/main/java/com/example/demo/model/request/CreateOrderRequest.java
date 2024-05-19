package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CreateOrderRequest {
    private List<Long> listCartItemId;

    private String address;

    private String phoneNumber;

    private String voucherCode;
}
