//package com.example.demo.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//import com.example.demo.entity.Category;
//import com.example.demo.model.request.CategoryRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.CategoryRepository;
//import com.example.demo.exception.CategoryNameExistException;
//import com.example.demo.model.dto.CategoryDto;
//
//@Service
//@Slf4j
//public class CategoryServiceImpl implements CategoryService{
//
//    private final CategoryRepository categoryRepository;
//
//    private final ModelMapper modelMapper;
//
//    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
//        this.categoryRepository = categoryRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> createCategory(CategoryRequest categoryRequest) {
//        log.info("Start API: createCategory with parameters: ({})", categoryRequest);
//        try {
//            if (categoryRepository.existsByName(categoryRequest.getName()))
//                throw new CategoryNameExistException(String.format("Category name %s is already exist", categoryRequest.getName()));
//            Category category = modelMapper.map(categoryRequest, Category.class);
//            categoryRepository.save(category);
//            log.info("End API: createCategory");
//            return new ResponseEntity<>(new ResponseApi<>("Create category success", 201), HttpStatus.CREATED);
//        } catch (CategoryNameExistException e) {
//            log.error("Error API: createCategory with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: createCategory with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<List<CategoryDto>>> getListCategories() {
//        log.info("Start API: getListCategories");
//        List<Category> listCategory = categoryRepository.findAll();
//        List<CategoryDto> listCategoryDto = listCategory.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
//        log.info("End API: getListCategories");
//        return new ResponseEntity<>(new ResponseApi<>("Get list categories success", 200, listCategoryDto), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> updateCategory(Long id, CategoryRequest categoryRequest) {
//        log.info("Start API: updateCategory with parameters: (id: {}, {})", id, categoryRequest);
//        try {
//            Optional<Category> optionalCategory = categoryRepository.findById(id);
//            if (categoryRepository.existsByName(categoryRequest.getName()))
//                throw new CategoryNameExistException(String.format("Category name %s is already exist", categoryRequest.getName()));
//            Category category = optionalCategory.get();
//            modelMapper.map(categoryRequest, category);
//            categoryRepository.save(category);
//            log.info("End API: updateCategory");
//            return new ResponseEntity<>(new ResponseApi<>("Update category success", 200), HttpStatus.OK);
//        } catch (CategoryNameExistException e) {
//            log.error("Error API: updateCategory with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: updateCategory with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
