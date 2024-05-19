package com.example.demo.service;

import com.example.demo.model.dto.VoucherDto;
import com.example.demo.model.request.VoucherRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VoucherService {
    ResponseEntity<ResponseApi<?>> createVoucher(VoucherRequest voucherRequest);

    ResponseEntity<ResponseApi<List<VoucherDto>>> getListVoucher();

    ResponseEntity<ResponseApi<List<VoucherDto>>> getAllVoucher();

    ResponseEntity<ResponseApi<?>> editVoucher(Long id, VoucherRequest voucherRequest);
}
