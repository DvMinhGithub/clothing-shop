package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfirmWebhookRequest {
    /**
     * Đường dẫn webhook nhận dữ liệu ngân hàng từ payOS của bạn
     */
    private String webhookUrl;
}
