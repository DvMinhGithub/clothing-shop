package com.example.demo.service;

import com.example.demo.exception.BrandNameExistException;
import com.example.demo.mapper.BrandMapper;
import com.example.demo.model.dto.BrandDto;
import com.example.demo.model.request.BrandRequest;
import com.example.demo.model.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createBrand(BrandRequest brandRequest) {
        log.info("Start API: createBrand with parameters: ({})", brandRequest);
        try {
            boolean brandExists = brandMapper.existsByName(brandRequest.getName());
            if (brandExists) {
                throw new BrandNameExistException(String.format("Brand name %s is already exist", brandRequest.getName()));
            }
            brandMapper.create(brandRequest);
            log.info("End API: createBrand");
            return new ResponseEntity<>(new ResponseApi<>("Thêm thương hiệu thành công"), HttpStatus.CREATED);
        } catch (BrandNameExistException e) {
            log.error("Error API: createBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>("Tên thương hiệu đã tồn tại"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: createBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<ResponseApi<List<BrandDto>>> getListBrands() {
        log.info("Start API: getListBrands");
        List<BrandDto> listBrand = brandMapper.findAll();
        log.info("End API: getListBrands");
        return new ResponseEntity<>(new ResponseApi<>("Get list brands success", listBrand), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateBrand(Long id, BrandRequest brandRequest) {
        log.info("Start API: updateBrand with parameters: (id: {}, {})", id, brandRequest);
        try {
            BrandDto brandDto = brandMapper.findById(id);
            boolean brandNameExists = brandMapper.existsByName(brandRequest.getName());
            if (!brandDto.getName().equals(brandRequest.getName()) && brandNameExists) {
                throw new BrandNameExistException(String.format("Brand name %s is already exist", brandRequest.getName()));
            }
            brandMapper.update(id, brandRequest);
            log.info("End API: updateBrand");
            return new ResponseEntity<>(new ResponseApi<>("Cập nhật thương hiệu thành công"), HttpStatus.OK);
        } catch (BrandNameExistException e) {
            log.error("Error API: updateBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>("Tên thương hiệu đã tồn tại"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: updateBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
