package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private Integer view;

    private Integer sold;

    private Double price;

    private String productImage;

    private Long brandId;

    private Boolean isDeleted;
}
