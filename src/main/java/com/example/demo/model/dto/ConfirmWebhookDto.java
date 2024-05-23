package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfirmWebhookDto {
    /**
     * Mã lỗi
     */
    private String code;

    /**
     * Thông tin lỗi
     */
    private String desc;
}
