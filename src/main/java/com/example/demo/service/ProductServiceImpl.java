package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.enums.UserRole;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.ChangeProductStatusRequest;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.response.ResponseApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    private final UploadService uploadService;

    public ProductServiceImpl(ProductMapper productMapper, UploadServiceImpl uploadService) {
        this.productMapper = productMapper;
        this.uploadService = uploadService;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createProduct(ProductRequest productRequest) {
        log.info("Start API: createProduct with parameters: ({})", productRequest);
        String productImage = null;
        if (productRequest.getImage() != null) {
            productImage = uploadService.uploadFile(productRequest.getImage());
        }

        ProductDto productDto = ProductDto.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .productImage(productImage)
                .brandId(productRequest.getBrandId())
                .isDeleted(false)
                .build();
        productMapper.create(productDto);

        if (productRequest.getCategoryIds() != null) {
            List<Long> listCategoryIds = new ArrayList<>();
            String[] arrCategoryIds = productRequest.getCategoryIds().split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
            for (Long categoryId : listCategoryIds) {
                productMapper.setCategory(productDto.getId(), categoryId);
            }
        }

        log.info("End API: createProduct");
        return new ResponseEntity<>(new ResponseApi<>("Create product success"), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResponseApi<?>> updateProduct(Long id, ProductRequest productRequest) {
        log.info("Start API: updateProduct with parameters: (id: {}, {})", id, productRequest);
        String productImage = null;
        if (productRequest.getImage() != null) {
            productImage = uploadService.uploadFile(productRequest.getImage());
        }

        ProductDto productDto = ProductDto.builder()
                .id(id)
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .productImage(productImage)
                .brandId(productRequest.getBrandId())
                .build();
        productMapper.updateProduct(productDto);

        productMapper.deleteCategory(productDto.getId());
        if (productRequest.getCategoryIds() != null) {
            List<Long> listCategoryIds = new ArrayList<>();
            String[] arrCategoryIds = productRequest.getCategoryIds().split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
            for (Long categoryId : listCategoryIds) {
                productMapper.setCategory(productDto.getId(), categoryId);
            }
        }
        log.info("End API: updateProduct");
        return new ResponseEntity<>(new ResponseApi<>("Update product success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getListProducts(String name, int page, int limit, String categoryIds, Long brandId) {
        log.info("Start API: getListProducts with parameters: (name: {}, page: {}, limit: {}, categoryIds: {}, brandId: {})", name, page, limit, categoryIds, brandId);
        PageHelper.startPage(page, limit);
        List<ProductDto> listProduct;
        List<Long> listCategoryIds = new ArrayList<>();
        if (categoryIds != null) {
            String[] arrCategoryIds = categoryIds.split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
        }
        listProduct = productMapper.getList(listCategoryIds, name, brandId);
        log.info("End API: getListProducts");
        return new ResponseEntity<>(new ResponseApi<>("Get list products success", new PageInfo<>(listProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getAllProducts(String name, int page, int limit, String categoryIds, Long brandId) {
        log.info("Start API: getAllProducts with parameters: (name: {}, page: {}, limit: {}, categoryIds: {}, brandId: {})", name, page, limit, categoryIds, brandId);
        PageHelper.startPage(page, limit);
        List<ProductDto> listProduct;
        List<Long> listCategoryIds = new ArrayList<>();
        if (categoryIds != null) {
            String[] arrCategoryIds = categoryIds.split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
        }
        listProduct = productMapper.getAll(listCategoryIds, name, brandId);
        log.info("End API: getAllProducts with parameters");
        return new ResponseEntity<>(new ResponseApi<>("Get all products success", new PageInfo<>(listProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id) {
        log.info("Start API: getProductById with parameters: (id: {})", id);
        ProductDetailDto productDetailDto = productMapper.getById(id);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean isCustomer = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals(UserRole.CUSTOMER.name()));

        if (isCustomer) {
            productMapper.updateView(id);
        }
        log.info("End API: getProductById");
        return new ResponseEntity<>(new ResponseApi<>("Get product success", productDetailDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> changeStatusProduct(Long id, ChangeProductStatusRequest changeProductStatusRequest) {
        log.info("Start API: changeStatusProduct with parameters: (id: {}, {})", id, changeProductStatusRequest);
        try {
            productMapper.updateStatus(id, changeProductStatusRequest.getStatus());
            log.info("End API: changeStatusProduct");
            return new ResponseEntity<>(new ResponseApi<>("Change product status success"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: changeStatusProduct with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopSoldProduct(String name, int page, int limit, String categoryIds, Long brandId) {
        log.info("Start API: getTopSoldProduct with parameters: (page: {}, limit: {})", page, limit);
        PageHelper.startPage(page, limit);
        List<ProductDto> listProduct;
        List<Long> listCategoryIds = new ArrayList<>();
        if (categoryIds != null) {
            String[] arrCategoryIds = categoryIds.split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
        }
        listProduct = productMapper.getTopSold(listCategoryIds, name, brandId);
        log.info("End API: getTopSoldProduct with parameters");
        return new ResponseEntity<>(new ResponseApi<>("Get top sold product success", new PageInfo<>(listProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<PageInfo<ProductDto>>> getTopViewProduct(String name, int page, int limit, String categoryIds, Long brandId) {
        log.info("Start API: getTopViewProduct with parameters: (page: {}, limit: {})", page, limit);
        PageHelper.startPage(page, limit);
        List<ProductDto> listProduct;
        List<Long> listCategoryIds = new ArrayList<>();
        if (categoryIds != null) {
            String[] arrCategoryIds = categoryIds.split(",");
            for (String categoryId : arrCategoryIds) {
                listCategoryIds.add(Long.parseLong(categoryId));
            }
        }
        listProduct = productMapper.getTopView(listCategoryIds, name, brandId);
        log.info("End API: getTopViewProduct with parameters");
        return new ResponseEntity<>(new ResponseApi<>("Get top view product success", new PageInfo<>(listProduct)), HttpStatus.OK);
    }
}