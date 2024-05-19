//package com.example.demo.repository;
//
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.Category;
//
//@Repository
//public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Boolean existsByName(String name);
//
//    @Query(value = "SELECT c.* FROM category c WHERE c.id IN :categoryIds", nativeQuery = true)
//    Set<Category> findByCategoryIds(@Param("categoryIds") List<Long> categoryIds);
//}
