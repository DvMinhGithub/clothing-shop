package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBatchDto {
    private Long id;

    private String productImage;

    private String productName;

    private String supplierName;

    private Integer quantity;

    private Double importPrice;

    private Timestamp createdAt;
}