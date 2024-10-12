package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.ProductFilterRequest;
import com.example.demo.model.request.RatingRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void create(@Param("productInfo") ProductDto productDto);

    void setCategory(@Param("productId") Long productId, @Param("categoryId") Long categoryId);

    void deleteCategory(@Param("productId") Long productId);

    List<ProductDto> getListProduct(@Param("pageRequest") PageRequest pageRequest,
                             @Param("listCategoryIds") List<Long> listCategoryIds,
                             @Param("filter")ProductFilterRequest productFilterRequest);

    Integer countListProduct(@Param("listCategoryIds") List<Long> listCategoryIds,
                             @Param("filter")ProductFilterRequest productFilterRequest);

    List<ProductDto> getTopSold(@Param("pageRequest") PageRequest pageRequest,
                                @Param("listCategoryIds") List<Long> listCategoryIds,
                                @Param("filter")ProductFilterRequest productFilterRequest);

    List<ProductDto> getTopView(@Param("pageRequest") PageRequest pageRequest,
                                @Param("listCategoryIds") List<Long> listCategoryIds,
                                @Param("filter")ProductFilterRequest productFilterRequest);

    void deleteProduct(@Param("productId") Long productId);

    void updateView(@Param("productId") Long productId);

    ProductDetailDto getById(@Param("userId") Long userId, @Param("productId") Long productId);

    void updateProduct(@Param("productInfo") ProductDto productDto);

    void updateSoldQuantity(@Param("quantity") Integer quantity, @Param("productId") Long productId);

    Boolean isRating(@Param("userId") Long userId, @Param("productId") Long productId);

    void updateRating(@Param("userId") Long userId, @Param("ratingInfo") RatingRequest ratingRequest);

    void ratingProduct(@Param("userId") Long userId, @Param("ratingInfo") RatingRequest ratingRequest);
}
