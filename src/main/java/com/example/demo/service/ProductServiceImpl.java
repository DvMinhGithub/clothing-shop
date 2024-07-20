package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.enums.UserRole;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDetailDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.RatingRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.utils.SecurityUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    private final UploadService uploadService;

    private final SecurityUtils securityUtils;

    public ProductServiceImpl(ProductMapper productMapper,
                              UploadServiceImpl uploadService,
                              SecurityUtils securityUtils) {
        this.productMapper = productMapper;
        this.uploadService = uploadService;
        this.securityUtils = securityUtils;
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
        return new ResponseEntity<>(new ResponseApi<>("Thêm sản phâm thành công"), HttpStatus.OK);
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
        return new ResponseEntity<>(new ResponseApi<>("Cập nhật sản phẩm thành công"), HttpStatus.OK);
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
    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id) {
        log.info("Start API: getProductById with parameters: (id: {})", id);
        Long userId = securityUtils.getUserLoggedInId();
        ProductDetailDto productDetailDto = productMapper.getById(userId, id);
        List<UserRole> listUserRole = securityUtils.getUserLoggedInRoles();
        boolean isCustomer = listUserRole.stream()
                .anyMatch(role -> role.equals(UserRole.CUSTOMER));

        if (isCustomer) {
            productMapper.updateView(id);
        }
        log.info("End API: getProductById");
        return new ResponseEntity<>(new ResponseApi<>("Get product success", productDetailDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> deleteProduct(Long id) {
        log.info("Start API: deleteProduct with parameters: (id: {})", id);
        try {
            productMapper.deleteProduct(id);
            log.info("End API: deleteProduct");
            return new ResponseEntity<>(new ResponseApi<>("Xoá sản phẩm thành công"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: deleteProduct with message: {}", e.getMessage());
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
        log.info("End API: getTopSoldProduct");
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
        log.info("End API: getTopViewProduct");
        return new ResponseEntity<>(new ResponseApi<>("Get top view product success", new PageInfo<>(listProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> ratingProduct(RatingRequest ratingRequest) {
        log.info("Start API: ratingProduct with parameters: ({})", ratingRequest);
        Long userId = securityUtils.getUserLoggedInId();
        Boolean isRating = productMapper.isRating(userId, ratingRequest.getProductId());
        if (isRating) {
            productMapper.updateRating(userId, ratingRequest);
        } else {
            productMapper.ratingProduct(userId, ratingRequest);
        }

        log.info("End API: ratingProduct");
        return new ResponseEntity<>(new ResponseApi<>("Rating product success"), HttpStatus.OK);
    }
}