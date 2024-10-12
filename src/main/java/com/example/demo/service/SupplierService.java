package com.example.demo.service;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<ResponseApi<?>> addSupplier(SupplierRequest supplierRequest);

    ResponseEntity<ResponseApi<CustomPageable<SupplierDto>>> getListSuppliers(String name, PageRequest pageRequest);

    ResponseEntity<ResponseApi<?>> updateSupplier(Long id, SupplierRequest supplierRequest);

    ResponseEntity<ResponseApi<?>> deleteSupplier(Long supplierId);
}
