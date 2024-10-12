package com.example.demo.service;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductBatchRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface ProductBatchService {
    ResponseEntity<ResponseApi<?>> createProductBatch(ProductBatchRequest productBatchRequest);

    ResponseEntity<ResponseApi<CustomPageable<ProductBatchDto>>> getListProductBatch(PageRequest pageRequest);
}
