package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void create(@Param("productInfo") ProductDto productDto);

    void setCategory(@Param("productId") Long productId, @Param("categoryId") Long categoryId);

    void setInventory(@Param("productId") Long productId,
                      @Param("importPrice") Double importPrice,
                      @Param("quantity") Integer quantity);

    void updateInventory(@Param("productId") Long productId,
                         @Param("importPrice") Double importPrice,
                         @Param("quantity") Integer quantity);

    void deleteCategory(@Param("productId") Long productId);

    List<ProductDto> getList(@Param("listCategoryIds") List<Long> listCategoryIds,
                             @Param("productName") String name,
                             @Param("brandId") Long brandId);

    List<ProductDto> getAll(@Param("listCategoryIds") List<Long> listCategoryIds,
                            @Param("productName") String name,
                            @Param("brandId") Long brandId);

    List<ProductDto> getTopSold(@Param("listCategoryIds") List<Long> listCategoryIds,
                                @Param("productName") String name,
                                @Param("brandId") Long brandId);

    List<ProductDto> getTopView(@Param("listCategoryIds") List<Long> listCategoryIds,
                                @Param("productName") String name,
                                @Param("brandId") Long brandId);

    void updateStatus(@Param("productId") Long productId,
                      @Param("productStatus") Boolean productStatus);

    void updateView(@Param("productId") Long productId);

    ProductDetailDto getById(@Param("productId") Long productId);

    void updateProduct(@Param("productInfo") ProductDto productDto);

    void updateInventoryAfterOrder(@Param("quantity") Integer quantity, @Param("productId") Long productId);

    void updateSoldQuantity(@Param("quantity") Integer quantity, @Param("productId") Long productId);
}
