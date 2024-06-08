package com.example.demo.service;

import com.example.demo.model.dto.PromotionDto;
import com.example.demo.model.request.PromotionRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

public interface PromotionService {
    ResponseEntity<ResponseApi<?>> createPromotion(PromotionRequest promotionRequest);

    ResponseEntity<ResponseApi<PageInfo<PromotionDto>>> getListPromotions(int page, int limit);

    ResponseEntity<ResponseApi<?>> updatePromotion(Long id, PromotionRequest promotionRequest);
}
