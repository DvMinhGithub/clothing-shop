package com.example.demo.mapper;

import com.example.demo.model.dto.ProductBatchDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductBatchRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductBatchMapper {
    void createBatch(@Param("productBatchInfo") ProductBatchRequest productBatchRequest);

    List<ProductBatchDto> getListProductBatch(@Param("pageRequest")PageRequest pageRequest);

    Integer countListProductBatch();
}
