package com.example.demo.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductFilterRequest {
    private String name;

    private List<String> categoryIds;

    private Long brandId;
}
