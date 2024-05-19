package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    void create(@Param("productInfo") ProductDto productDto);

    void setCategory(@Param("productId") Long productId, @Param("categoryId") Long categoryId);

    void setInventory(@Param("productId") Long productId, @Param("importPrice") Double importPrice, @Param("quantity") Integer quantity);
}
