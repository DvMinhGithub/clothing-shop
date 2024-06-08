package com.example.demo.service;

import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<ResponseApi<?>> addSupplier(SupplierRequest supplierRequest);

    ResponseEntity<ResponseApi<PageInfo<SupplierDto>>> getListSuppliers(String name, int page, int limit);

    ResponseEntity<ResponseApi<?>> updateSupplier(Long id ,SupplierRequest supplierRequest);
}
