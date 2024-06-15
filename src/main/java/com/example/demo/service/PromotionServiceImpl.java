package com.example.demo.service;

import com.example.demo.exception.DuplicatePromotionException;
import com.example.demo.mapper.PromotionMapper;
import com.example.demo.model.dto.PromotionDto;
import com.example.demo.model.request.PromotionRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class PromotionServiceImpl implements PromotionService {
    private final PromotionMapper promotionMapper;

    public PromotionServiceImpl(PromotionMapper promotionMapper) {
        this.promotionMapper = promotionMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createPromotion(PromotionRequest promotionRequest) {
        log.info("Start API: createPromotion with parameters: ({})", promotionRequest);
        try {
            if (promotionMapper.isDuplicatePromotionTime(promotionRequest)) {
                throw new DuplicatePromotionException("Duplicate promotion for this product");
            }
            promotionMapper.create(promotionRequest);
            log.info("End API: createPromotion");
            return new ResponseEntity<>(new ResponseApi<>("Create promotion success"), HttpStatus.OK);
        } catch (DuplicatePromotionException e) {
            log.error("Error API: createPromotion with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<PromotionDto>>> getListPromotions(int page, int limit) {
        log.info("Start API: getListPromotions with parameters: (page: {}, limit: {})", page, limit);
        PageHelper.startPage(page, limit);
        List<PromotionDto> listPromotion = promotionMapper.getListPromotion();
        log.info("End API: getListPromotions");
        return new ResponseEntity<>(new ResponseApi<>("Get list promotion success", new PageInfo<>(listPromotion)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updatePromotion(Long id, PromotionRequest promotionRequest) {
        log.info("Start API: updatePromotion with parameters: (id: {}, {})", id, promotionRequest);
        try {
            if (promotionMapper.isDuplicatePromotionTime(promotionRequest)) {
                throw new DuplicatePromotionException("Duplicate promotion for this product");
            }
            promotionMapper.update(id, promotionRequest);
            log.info("End API: updatePromotion");
            return new ResponseEntity<>(new ResponseApi<>("Update promotion success"), HttpStatus.OK);
        } catch (DuplicatePromotionException e) {
            log.error("Error API: updatePromotion with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updatePromotionStatus(Long id, PromotionRequest promotionRequest) {
        log.info("Start API: updatePromotionStatus with parameters: (id: {}, {})", id, promotionRequest);
        try {
            promotionMapper.updatePromotionStatus(id, promotionRequest);
            log.info("End API: updatePromotionStatus");
            return new ResponseEntity<>(new ResponseApi<>("Update promotion status success"), HttpStatus.OK);
        } catch (DuplicatePromotionException e) {
            log.error("Error API: updatePromotionStatus with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
