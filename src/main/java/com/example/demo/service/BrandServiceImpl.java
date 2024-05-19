package com.example.demo.service;

import com.example.demo.mapper.BrandMapper;
import com.example.demo.model.dto.BrandDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BrandNameExistException;
import com.example.demo.model.request.BrandRequest;
import com.example.demo.model.response.ResponseApi;

import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;

    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandMapper brandMapper, ModelMapper modelMapper) {
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createBrand(BrandRequest brandRequest) {
        log.info("Start API: createBrand with parameters: ({})", brandRequest);
        try {
            if (brandMapper.existsByName(brandRequest.getName()))
                throw new BrandNameExistException(String.format("Brand name %s is already exist", brandRequest.getName()));
            brandMapper.createBrand(brandRequest);
            log.info("End API: createBrand");
            return new ResponseEntity<>(new ResponseApi<>("Create brand success", 201), HttpStatus.CREATED);
        } catch (BrandNameExistException e) {
            log.error("Error API: createBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
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
            if (brandMapper.existsByName(brandRequest.getName()))
                throw new BrandNameExistException(String.format("Brand name %s is already exist", brandRequest.getName()));
            brandMapper.updateBrand(id, brandRequest);
            log.info("End API: updateBrand");
            return new ResponseEntity<>(new ResponseApi<>("Update brand success", 200), HttpStatus.OK);
        } catch (BrandNameExistException e) {
            log.error("Error API: updateBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: updateBrand with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
