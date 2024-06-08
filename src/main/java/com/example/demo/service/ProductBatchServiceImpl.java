package com.example.demo.service;

import com.example.demo.mapper.ProductBatchMapper;
import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.ProductBatchRequest;
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
public class ProductBatchServiceImpl implements ProductBatchService {
    private final ProductBatchMapper productBatchMapper;

    public ProductBatchServiceImpl(ProductBatchMapper productBatchMapper) {
        this.productBatchMapper = productBatchMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createProductBatch(ProductBatchRequest productBatchRequest) {
        log.info("Start API: createProductBatch with parameters: ({})", productBatchRequest);
        productBatchMapper.createBatch(productBatchRequest);
        log.info("End API: createProductBatch");
        return new ResponseEntity<>(new ResponseApi<>("Create batch success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<ProductBatchDto>>> getListProductBatch(int page, int limit) {
        log.info("Start API: getListProductBatch with parameters: (page: {}, limit: {})", page, limit);
        PageHelper.startPage(page, limit);
        List<ProductBatchDto> listProductBatch = productBatchMapper.getListProductBatch();
        log.info("End API: getListProductBatch");
        return new ResponseEntity<>(new ResponseApi<>("Get supplier success", new PageInfo<>(listProductBatch)), HttpStatus.OK);
    }


}
