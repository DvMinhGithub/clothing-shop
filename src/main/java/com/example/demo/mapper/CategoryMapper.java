package com.example.demo.mapper;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.request.CategoryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    Boolean existsByName(@Param("categoryName") String categoryName);

    void create(@Param("categoryInfo") CategoryRequest categoryRequest);

    List<CategoryDto> findAll();

    CategoryDto findById(@Param("categoryId") Long categoryId);

    void update(@Param("categoryId")Long categoryId, @Param("categoryInfo")CategoryRequest categoryRequest);
}
