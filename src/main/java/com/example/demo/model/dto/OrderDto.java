package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long id;
    private Double totalPrice;
    private String phoneNumber;
    private String address;
    private LocalDate createdAt;
    private String status;
    private List<ShopOrder> shopOrders;

    @Data
    @Builder
    public static class ShopOrder {
        private Long shopId;
        private String nameShop;
        private List<ProductOrder> productOrders;
    }

    @Data
    @Builder
    public static class ProductOrder {
        private Long shopId;
        private String nameShop;
        private List<ProductAttributeOrder> productAttributeOrders;
    }

    @Data
    @Builder
    public static class ProductAttributeOrder {
        private Long productAttributeId;
        private String productAttributeName;
    }
}
