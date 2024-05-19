//package com.example.demo.service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.exception.ProductNotFoundException;
//import com.example.demo.model.dto.CategoryDto;
//import com.example.demo.model.dto.ProductDetailDto;
//import com.example.demo.model.dto.ProductDto;
//import com.example.demo.model.request.ChangeProductStatusRequest;
//import com.example.demo.model.request.ProductRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.BrandRepository;
//import com.example.demo.repository.CategoryRepository;
//import com.example.demo.repository.ProductInventoryRepository;
//import com.example.demo.repository.ProductRepository;
//import com.example.demo.utils.Convert;
//
//import lombok.extern.slf4j.Slf4j;
//import redis.clients.jedis.Jedis;
//
//@Service
//@Slf4j
//public class ProductServiceImpl implements ProductService {
//    private final ProductRepository productRepository;
//
//    private final CategoryRepository categoryRepository;
//
//    private final ModelMapper modelMapper;
//
//    private final BrandRepository brandRepository;
//
//    private final UploadServiceImpl uploadService;
//
//    private final ProductInventoryRepository productInventoryRepository;
//
//    private final Jedis jedis;
//
//    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository, ModelMapper modelMapper, UploadServiceImpl uploadService, ProductInventoryRepository productInventoryRepository, Jedis jedis) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.modelMapper = modelMapper;
//        this.brandRepository = brandRepository;
//        this.uploadService = uploadService;
//        this.productInventoryRepository = productInventoryRepository;
//        this.jedis = jedis;
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> createProduct(ProductRequest productRequest) {
//        log.info("Start API: createProduct with parameters: ({})", productRequest);
//        try {
//            Product product = modelMapper.map(productRequest, Product.class);
//            if (productRequest.getImage() != null) {
//                String productImage = uploadService.uploadFile(productRequest.getImage());
//                product.setProductImage(productImage);
//            }
//            if (productRequest.getBrandId() != null) {
//                Brand brand = brandRepository.findById(productRequest.getBrandId()).get();
//                product.setBrand(brand);
//            }
//
//            if (productRequest.getCategoryIds() != null) {
//                List<Long> listCategoryId = Convert.convertJsonToListLong(productRequest.getCategoryIds());
//                Set<Category> listCategory = categoryRepository.findByCategoryIds(listCategoryId);
//                product.setListCategory(listCategory);
//            }
//            Product savedProduct = productRepository.save(product);
//
//            ProductInventory productInventory = new ProductInventory();
//            productInventory.setProduct(savedProduct);
//            productInventory.setQuantity(productRequest.getQuantity());
//            productInventory.setImportPrice(productRequest.getImportPrice());
//            productInventoryRepository.save(productInventory);
//            log.info("End API: createProduct");
//            return new ResponseEntity<>(new ResponseApi<>("Create product success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: createProduct with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> updateProduct(Long id, ProductRequest productRequest) throws IOException {
//        log.info("Start API: updateProduct with parameters: (id: {}, {})", id, productRequest);
//        try {
//            Product product = productRepository.findById(id).get();
//            modelMapper.map(productRequest, product);
//            if (productRequest.getImage() != null) {
//                String productImage = uploadService.uploadFile(productRequest.getImage());
//                product.setProductImage(productImage);
//            }
//
//            if (productRequest.getBrandId() != null) {
//                Brand brand = brandRepository.findById(productRequest.getBrandId()).get();
//                product.setBrand(brand);
//            }
//
//            if (productRequest.getCategoryIds() != null) {
//                product.getListCategory().clear();
//                List<Long> listCategoryId = Convert.convertJsonToListLong(productRequest.getCategoryIds());
//                Set<Category> listCategory = categoryRepository.findByCategoryIds(listCategoryId);
//                product.setListCategory(listCategory);
//                product.setListCategory(listCategory);
//            }
//
//            Product savedProduct = productRepository.save(product);
//
//            ProductInventory productInventory = productInventoryRepository.findByProductId(savedProduct.getId());
//            productInventory.setQuantity(productRequest.getQuantity());
//            productInventory.setImportPrice(productRequest.getImportPrice());
//            productInventoryRepository.save(productInventory);
//            log.info("End API: updateProduct");
//            return new ResponseEntity<>(new ResponseApi<>("Update product success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: updateProduct with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getListProducts(String name, int page, int limit, String categoryIds, Long brandId) {
//        log.info("Start API: getListProducts with parameters: (name: {}, page: {}, limit: {}, categoryIds: {}, brandId: {})", name, page, limit, categoryIds, brandId);
//        Page<Product> productInPage;
//        Pageable pageable = PageRequest.of(page, limit);
//
//        if (categoryIds != null) {
//            List<Long> listLongCategoryIds = new ArrayList<>();
//            String[] arrCategoryIds = categoryIds.split(",");
//            for (String categoryId : arrCategoryIds) {
//                listLongCategoryIds.add(Long.parseLong(categoryId));
//            }
//            productInPage = productRepository.getListProductWithCategoryIds(listLongCategoryIds, listLongCategoryIds.size(), name, brandId, pageable);
//        } else {
//            productInPage = productRepository.getListProduct(name, brandId, pageable);
//        }
//
//        Page<ProductDto> productDtoInPage = productInPage.map(product -> modelMapper.map(product, ProductDto.class));
//        log.info("End API: getListProducts");
//        return new ResponseEntity<>(new ResponseApi<>("Get list products success", 200, productDtoInPage), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getAllProducts(String name, int page, int limit, String categoryIds, Long brandId) {
//        log.info("Start API: getAllProducts with parameters: (name: {}, page: {}, limit: {}, categoryIds: {}, brandId: {})", name, page, limit, categoryIds, brandId);
//        Page<Product> productInPage;
//        Pageable pageable = PageRequest.of(page, limit);
//
//        if (categoryIds != null) {
//            List<Long> listLongCategoryIds = new ArrayList<>();
//            String[] arrCategoryIds = categoryIds.split(",");
//            for (String categoryId : arrCategoryIds) {
//                listLongCategoryIds.add(Long.parseLong(categoryId));
//            }
//            productInPage = productRepository.getAllProductWithCategoryIds(listLongCategoryIds, listLongCategoryIds.size(), name, brandId, pageable);
//        } else {
//            productInPage = productRepository.getAllProduct(name, brandId, pageable);
//        }
//
//        Page<ProductDto> productDtoInPage = productInPage.map(product -> modelMapper.map(product, ProductDto.class));
//        log.info("End API: getAllProducts with parameters");
//        return new ResponseEntity<>(new ResponseApi<>("Get all products success", 200, productDtoInPage), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<ProductDetailDto>> getProductById(Long id) {
//        log.info("Start API: getProductById with parameters: (id: {})", id);
//        Optional<Product> optionalProduct = productRepository.getProductById(id);
//        if (optionalProduct.isEmpty())
//            throw new ProductNotFoundException(String.format("ProductID#%s does not exist", id));
//        Product product = optionalProduct.get();
//        ProductDetailDto productDetailDto = modelMapper.map(product, ProductDetailDto.class);
//        productDetailDto.setBrand(product.getBrand());
//        productDetailDto.setQuantity(product.getProductInventory().getQuantity());
//        productDetailDto.setListCategory(product.getListCategory().stream()
//                .map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toSet()));
//
//        product.setView(product.getView() + 1);
//        productRepository.save(product);
//        log.info("End API: getProductById");
//        return new ResponseEntity<>(new ResponseApi<>("Get product success", 200, productDetailDto), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> changeStatusProduct(Long id, ChangeProductStatusRequest changeProductStatusRequest) {
//        log.info("Start API: changeStatusProduct with parameters: (id: {}, {})", id, changeProductStatusRequest);
//        try {
//            Product product = productRepository.findById(id).get();
//            product.setHasShow(changeProductStatusRequest.getStatus());
//            productRepository.save(product);
//            log.info("End API: changeStatusProduct");
//            return new ResponseEntity<>(new ResponseApi<>("Change product status success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: changeStatusProduct with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getTopSellersProducts(int page, int limit) {
//        log.info("Start API: getTopSellersProducts with parameters: (page: {}, limit: {})", page, limit);
//        Pageable pageable = PageRequest.of(page, limit);
//        Page<Product> productInPage = productRepository.getTopSellersProducts(pageable);
//        Page<ProductDto> productDtoInPage = productInPage.map(product -> modelMapper.map(product, ProductDto.class));
//        log.info("End API: getTopSellersProducts with parameters");
//        return new ResponseEntity<>(new ResponseApi<>("Get top sellers products success", 200, productDtoInPage), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<Page<ProductDto>>> getTopViewedProducts(int page, int limit) {
//        log.info("Start API: getTopViewedProducts with parameters: (page: {}, limit: {})", page, limit);
//        Page<Product> productInPage;
//        Pageable pageable = PageRequest.of(page, limit);
//        productInPage = productRepository.getTopViewedProducts( pageable);
//        Page<ProductDto> productDtoInPage = productInPage.map(product -> modelMapper.map(product, ProductDto.class));
//        log.info("End API: getTopViewedProducts with parameters");
//        return new ResponseEntity<>(new ResponseApi<>("Get top sellers products success", 200, productDtoInPage), HttpStatus.OK);
//    }
//}