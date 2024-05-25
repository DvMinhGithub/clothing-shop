package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ProductRequest {
    private String name;

    private String description;

    private String attribute;

    private Double importPrice;

    private Double price;

    private Long brandId;

    private String categoryIds;

    private Integer quantity;

    private MultipartFile image;

    private Boolean isDeleted;
}
