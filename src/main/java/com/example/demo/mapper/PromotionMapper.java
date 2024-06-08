package com.example.demo.mapper;

import com.example.demo.model.dto.PromotionDto;
import com.example.demo.model.request.PromotionRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PromotionMapper {
    void create(@Param("promotionInfo")PromotionRequest promotionRequest);

    List<PromotionDto> getListPromotion();

    void update(@Param("promotionId")Long promotionId, @Param("promotionInfo")PromotionRequest promotionRequest);
}
