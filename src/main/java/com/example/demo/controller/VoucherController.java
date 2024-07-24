package com.example.demo.controller;

import com.example.demo.model.dto.VoucherDto;
import com.example.demo.model.request.VoucherRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.VoucherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "*")
public class VoucherController {

    private final VoucherServiceImpl voucherService;

    public VoucherController(VoucherServiceImpl voucherService) {
        this.voucherService = voucherService;
    }

    @Operation(summary = "Create voucher", description = "Create voucher")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseApi<?>> createVoucher(@RequestBody VoucherRequest voucherRequest) {
        return voucherService.createVoucher(voucherRequest);
    }

    @Operation(summary = "Get list voucher", description = "Get list voucher")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @GetMapping(value = "/getVoucherValid")
    public ResponseEntity<ResponseApi<List<VoucherDto>>> getVoucherValid() {
        return voucherService.getVoucherValid();
    }

    @Operation(summary = "Get all voucher", description = "Get all voucher")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured({"EMPLOYEE", "ADMIN"})
    @GetMapping(value = "/getAll")
    public ResponseEntity<ResponseApi<List<VoucherDto>>> getAllVoucher() {
        return voucherService.getAllVoucher();
    }

    @Operation(summary = "Find voucher by code", description = "Find voucher by code")
    @SecurityRequirement(name = "Bearer Authentication")
    @Secured("CUSTOMER")
    @GetMapping(value = "/getByCode")
    public ResponseEntity<ResponseApi<VoucherDto>> getVoucherByCode(
            @RequestParam(value = "code") String code) {
        return voucherService.getVoucherByCode(code);
    }

//    @Operation(summary = "Edit voucher", description = "Edit voucher")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PostMapping(value = "/edit/{id}")
//    public ResponseEntity<ResponseApi<?>> editVoucher(@PathVariable Long id, @RequestBody VoucherRequest voucherRequest) {
//        return voucherService.editVoucher(id, voucherRequest);
//    }
}
