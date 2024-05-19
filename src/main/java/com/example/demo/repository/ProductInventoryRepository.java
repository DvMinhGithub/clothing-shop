//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.ProductInventory;
//
//@Repository
//public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
//    @Query(value = "SELECT pi.* FROM product_inventory pi WHERE pi.product_id = :productId",nativeQuery = true)
//    ProductInventory findByProductId(@Param("productId") Long productId);
//}
