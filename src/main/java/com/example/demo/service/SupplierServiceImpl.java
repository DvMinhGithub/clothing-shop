package com.example.demo.service;

import com.example.demo.mapper.SupplierMapper;
import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.SupplierRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return new ResponseEntity<>(new ResponseApi<>("Add supplier success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<SupplierDto>>> getListSuppliers(String name, int page, int limit) {
        log.info("Start API: getSupplier with parameters: (name: {}, page: {}, limit: {})", name, page, limit);
        PageHelper.startPage(page, limit);
        List<SupplierDto> listSupplier = supplierMapper.getListSupplier();
        log.info("End API: getSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Get supplier success", new PageInfo<>(listSupplier)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateSupplier(Long id, SupplierRequest supplierRequest) {
        log.info("Start API: updateSupplier with parameters: ({})", supplierRequest);
        supplierMapper.updateSupplier(id, supplierRequest);
        log.info("End API: updateSupplier");
        return new ResponseEntity<>(new ResponseApi<>("Update supplier success"), HttpStatus.OK);
    }
}
