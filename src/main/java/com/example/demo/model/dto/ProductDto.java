package com.example.demo.model.dto;

import lombok.*;

@Getter
@Setter
public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private Integer view = 0;

    private Integer sold = 0;

    private String attribute;

    private Double price;

    private String productImage;
}
