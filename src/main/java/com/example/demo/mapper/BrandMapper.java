package com.example.demo.mapper;

import com.example.demo.model.dto.BrandDto;
import com.example.demo.model.request.BrandRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {
    Boolean existsByName(@Param("brandName") String brandName);

    void createBrand(@Param("brandInfo") BrandRequest brandRequest);

    List<BrandDto> findAll();

    BrandDto findById(@Param("brandId") Long id);

    BrandDto updateBrand(@Param("brandId")Long brandId, @Param("brandInfo")BrandRequest brandRequest);
}
