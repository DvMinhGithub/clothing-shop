package com.example.demo.service;

import com.example.demo.mapper.SupplierMapper;
import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> addSupplier(SupplierRequest supplierRequest) {
        log.info("Start API: addSupplier with parameters: ({})", supplierRequest);
        supplierMapper.addSupplier(supplierRequest);
        log.info("End API: addSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Thêm nhà cung cấp thành công"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<CustomPageable<SupplierDto>>> getListSuppliers(String name, PageRequest pageRequest) {
        log.info("Start API: getSupplier with parameters: (name: {}, pageRequest: {})", name, pageRequest);
        List<SupplierDto> listSupplier = supplierMapper.getListSupplier(pageRequest);
        Integer countListSupplier = supplierMapper.countListSupplier();
        log.info("End API: getSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Get supplier success", new CustomPageable<>(listSupplier, countListSupplier, pageRequest)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateSupplier(Long id, SupplierRequest supplierRequest) {
        log.info("Start API: updateSupplier with parameters: ({})", supplierRequest);
        supplierMapper.updateSupplier(id, supplierRequest);
        log.info("End API: updateSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Cập nhật nhà cung cấp thành công"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> deleteSupplier(Long supplierId) {
        log.info("Start API: deleteSupplier with parameters: ({})", supplierId);
        supplierMapper.deleteSupplier(supplierId);
        log.info("End API: deleteSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Xoá nhà cung cấp thành công"), HttpStatus.OK);
    }
}
