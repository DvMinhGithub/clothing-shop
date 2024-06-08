package com.example.demo.service;

import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.ProductBatchRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

public interface ProductBatchService {
    ResponseEntity<ResponseApi<?>> createProductBatch(ProductBatchRequest productBatchRequest);

    ResponseEntity<ResponseApi<PageInfo<ProductBatchDto>>> getListProductBatch(int page, int limit);
}
