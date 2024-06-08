package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierRequest {
    private String name;

    private String phoneNumber;

    private String address;
}
