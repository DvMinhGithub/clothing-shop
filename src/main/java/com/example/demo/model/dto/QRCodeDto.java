package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QRCodeDto {
    private String code;

    private String desc;

    private QRCodeData data;

    @Data
    @Builder
    public static class QRCodeData {
        private String acpId;

        private String accountName;

        private String qrCode;

        private String qrDataURL;
    }
}
