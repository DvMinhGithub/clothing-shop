package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {
    private Long id;

    private String name;

    private String description;

    private Integer view;

    private Integer sold;

    private Boolean isDeleted;

    private String attribute;

    private Double price;

    private String productImage;

    private BrandDto brand;

    private Integer quantity;

    private Double totalRating;

    private Double userRating;

    private Double priceAfterDiscount;

    private List<CategoryDto> listCategory;

    private Integer totalUserRating;
}
