//package com.example.demo.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import com.example.demo.model.dto.VoucherDto;
//import com.example.demo.model.request.VoucherRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.service.VoucherServiceImpl;
//
//@RestController
//@RequestMapping("/voucher")
//public class VoucherController {
//
//    private final VoucherServiceImpl voucherService;
//
//    public VoucherController(VoucherServiceImpl voucherService) {
//        this.voucherService = voucherService;
//    }
//
//    @Operation(summary = "Create voucher", description = "Create voucher")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PostMapping(value = "/create")
//    public ResponseEntity<ResponseApi<?>> createProduct(@RequestBody VoucherRequest voucherRequest) {
//        return voucherService.createVoucher(voucherRequest);
//    }
//
//    @Operation(summary = "Get list voucher", description = "Get list voucher")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured("CUSTOMER")
//    @GetMapping(value = "/getList")
//    public ResponseEntity<ResponseApi<List<VoucherDto>>> getListVoucher() {
//        return voucherService.getListVoucher();
//    }
//
//    @Operation(summary = "Get all voucher", description = "Get all voucher")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PostMapping(value = "/getAll")
//    public ResponseEntity<ResponseApi<List<VoucherDto>>> getAllVoucher() {
//        return voucherService.getAllVoucher();
//    }
//
//    @Operation(summary = "Edit voucher", description = "Edit voucher")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured({"EMPLOYEE", "ADMIN"})
//    @PostMapping(value = "/edit/{id}")
//    public ResponseEntity<ResponseApi<?>> editVoucher(@PathVariable Long id, @RequestBody VoucherRequest voucherRequest) {
//        return voucherService.editVoucher(id, voucherRequest);
//    }
//}
