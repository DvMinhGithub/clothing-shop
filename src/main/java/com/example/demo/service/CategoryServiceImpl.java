package com.example.demo.service;

import com.example.demo.exception.CategoryNameExistException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.request.CategoryRequest;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createCategory(CategoryRequest categoryRequest) {
        log.info("Start API: createCategory with parameters: ({})", categoryRequest);
        try {
            if (categoryMapper.existsByName(categoryRequest.getName()))
                throw new CategoryNameExistException(String.format("Category name %s is already exist", categoryRequest.getName()));
            categoryMapper.create(categoryRequest);
            log.info("End API: createCategory");
            return new ResponseEntity<>(new ResponseApi<>("Thêm danh mục thành công"), HttpStatus.CREATED);
        } catch (CategoryNameExistException e) {
            log.error("Error API: createCategory with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>("Tên danh mục đã tồn tại"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: createCategory with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<List<CategoryDto>>> getListCategories() {
        log.info("Start API: getListCategories");
        List<CategoryDto> listCategory = categoryMapper.findAll();
        log.info("End API: getListCategories");
        return new ResponseEntity<>(new ResponseApi<>("Get list categories success", listCategory), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateCategory(Long id, CategoryRequest categoryRequest) {
        log.info("Start API: updateCategory with parameters: (id: {}, {})", id, categoryRequest);
        try {
            CategoryDto categoryDto = categoryMapper.findById(id);
            if (!categoryDto.getName().equals(categoryRequest.getName()) && categoryMapper.existsByName(categoryRequest.getName()))
                throw new CategoryNameExistException(String.format("Category name %s is already exist", categoryRequest.getName()));
            categoryMapper.update(id, categoryRequest);
            log.info("End API: updateCategory");
            return new ResponseEntity<>(new ResponseApi<>("Cập nhật danh mục thành công"), HttpStatus.OK);
        } catch (CategoryNameExistException e) {
            log.error("Error API: updateCategory with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>("Tên danh mục đã tồn tại"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: updateCategory with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
