package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentRequest {
    /**
     * Mã đơn hàng(bắt buộc)
     */
    private Long orderCode;

    /**
     * Số tiền thanh toán(bắt buộc)
     */
    private Integer amount;

    /**
     * Mô tả thanh toán, với tài khoản ngân hàng không phải liên kết qua payOS thì giới hạn ký tự là 9(bắt buộc)
     */
    private String description;

    /**
     * URL nhận dữ liệu khi người dùng chọn Huỷ đơn hàng(bắt buộc)
     */
    private String cancelUrl;

    /**
     * URL nhận dữ liệu khi đơn hàng thanh toán thành công(bắt buộc)
     */
    private String returnUrl;

    /**
     * Thời gian hết hạn của link thanh toán, là Unix Timestamp và kiểu Int32
     */
    private long expiredAt;

    /**
     * Chữ ký kiểm tra thông tin không bị thay đổi trong qua trình chuyển dữ liệu từ hệ thống của bạn sang payOS. Bạn cần dùng checksum key từ Kênh thanh toán và HMAC_SHA256 để tạo signature và data theo định dạng được sort theo alphabet: amount=$amount&cancelUrl=$cancelUrl&description=$description&orderCode=$orderCode&returnUrl=$returnUrl.
     */
    private String signature;
}
