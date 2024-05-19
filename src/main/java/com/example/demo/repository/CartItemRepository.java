//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//import com.example.demo.entity.CartItem;
//
//@Repository
//public interface CartItemRepository extends JpaRepository<CartItem, Long> {
//    @Query(value = "SELECT ci FROM CartItem ci JOIN FETCH ci.product WHERE ci.user.id = :userId")
//    List<CartItem> findByUserId(@Param("userId")Long userId);
//
//
//    @Query(value = "SELECT ci FROM CartItem ci JOIN FETCH ci.product WHERE ci.id IN (:cartItemIds)")
//    List<CartItem> getListCartItem(@Param("cartItemIds") List<Long> categoryIds);
//
//
//    @Modifying
//    @Query(value = "DELETE FROM cart_item ci WHERE ci.id IN (:cartItemIds)", nativeQuery = true)
//    void deleteListCartItem(@Param("cartItemIds") List<Long> categoryIds);
//}
