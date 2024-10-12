package com.example.demo.service;

import com.example.demo.model.CustomPageable;
import com.example.demo.model.dto.PromotionDto;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.request.PromotionRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface PromotionService {
    ResponseEntity<ResponseApi<?>> createPromotion(PromotionRequest promotionRequest);

    ResponseEntity<ResponseApi<CustomPageable<PromotionDto>>> getListPromotions(PageRequest pageRequest);

    ResponseEntity<ResponseApi<?>> updatePromotion(Long id, PromotionRequest promotionRequest);

    ResponseEntity<ResponseApi<?>> updatePromotionStatus(Long id, PromotionRequest promotionRequest);
}
