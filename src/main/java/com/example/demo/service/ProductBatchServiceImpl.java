package com.example.demo.service;

import com.example.demo.mapper.ProductBatchMapper;
import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductBatchRequest;
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
public class ProductBatchServiceImpl implements ProductBatchService {
    private final ProductBatchMapper productBatchMapper;

    public ProductBatchServiceImpl(ProductBatchMapper productBatchMapper) {
        this.productBatchMapper = productBatchMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createProductBatch(ProductBatchRequest productBatchRequest) {
        log.info("Start API: createProductBatch with parameters: (productBatchRequest: {})", productBatchRequest);
        productBatchMapper.createBatch(productBatchRequest);
        log.info("End API: createProductBatch");
        return new ResponseEntity<>(new ResponseApi<>("Create batch success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<CustomPageable<ProductBatchDto>>> getListProductBatch(PageRequest pageRequest) {
        log.info("Start API: getListProductBatch with parameters: (pageRequest: {})", pageRequest);
        List<ProductBatchDto> listProductBatch = productBatchMapper.getListProductBatch(pageRequest);
        Integer countListProductBatch = productBatchMapper.countListProductBatch();
        var result = new CustomPageable<>(listProductBatch, countListProductBatch, pageRequest);
        log.info("End API: getListProductBatch");
        return new ResponseEntity<>(new ResponseApi<>("Get supplier success", result), HttpStatus.OK);
    }


}
