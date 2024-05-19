//package com.example.demo.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.Product;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, Long> {
//
//    @Query(value = "SELECT p FROM Product p WHERE p.hasShow = false ORDER BY p.sold DESC")
//    Page<Product> getTopSellersProducts(Pageable pageable);
//
//    @Query(value = "SELECT p FROM Product p WHERE p.hasShow = false ORDER BY p.view DESC")
//    Page<Product> getTopViewedProducts( Pageable pageable);
//
//    @Query(value = "SELECT p FROM Product p JOIN FETCH p.brand JOIN FETCH p.listCategory JOIN FETCH p.productInventory WHERE p.id = :productId")
//    Optional<Product> getProductById(@Param("productId") Long productId);
//
//
//    @Query(value = "SELECT p.* FROM product p WHERE (:nameProduct is null or p.name LIKE %:nameProduct%) AND " +
//            "(:brandId is null or p.brand_id = :brandId) AND p.is_show = false", nativeQuery = true)
//    Page<Product> getListProduct(@Param("nameProduct") String nameProduct,
//                                 @Param("brandId") Long brandId,
//                                 Pageable pageable);
//
//    @Query(value = "SELECT p.* FROM (SELECT p2.id FROM product p2 INNER JOIN category_product cp ON p2.id = cp.product_id " +
//            "WHERE cp.category_id IN (:categoryIds) GROUP BY p2.id HAVING COUNT(p2.id) = :numberOfCategoryIds) AS selected_product_ids " +
//            "INNER JOIN product p ON p.id = selected_product_ids.id " +
//            "WHERE (:nameProduct is null or p.name LIKE %:nameProduct%) AND (:brandId is null or p.brand_id = :brandId) AND p.is_show = false", nativeQuery = true)
//    Page<Product> getListProductWithCategoryIds(@Param("categoryIds") List<Long> categoryIds,
//                                                @Param("numberOfCategoryIds") int numberOfCategoryIds,
//                                                @Param("nameProduct") String nameProduct, @Param("brandId") Long brandId, Pageable pageable);
//
//    @Query(value = "SELECT p.* FROM product p WHERE (:nameProduct is null or p.name LIKE %:nameProduct%) AND (:brandId is null or p.brand_id = :brandId)", nativeQuery = true)
//    Page<Product> getAllProduct(@Param("nameProduct") String nameProduct,
//                                @Param("brandId") Long brandId,
//                                Pageable pageable);
//
//    @Query(value = "SELECT p.* FROM (SELECT p2.id FROM product p2 INNER JOIN category_product cp ON p2.id = cp.product_id " +
//            "WHERE cp.category_id IN (:categoryIds) GROUP BY p2.id HAVING COUNT(p2.id) = :numberOfCategoryIds) AS selected_product_ids " +
//            "INNER JOIN product p ON p.id = selected_product_ids.id WHERE (:nameProduct is null or p.name LIKE %:nameProduct%) AND (:brandId is null or p.brand_id = :brandId)", nativeQuery = true)
//    Page<Product> getAllProductWithCategoryIds(@Param("categoryIds") List<Long> categoryIds,
//                                               @Param("numberOfCategoryIds") int numberOfCategoryIds,
//                                               @Param("nameProduct") String nameProduct, @Param("brandId") Long brandId, Pageable pageable);
//
//
//}