//package com.example.demo.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.User;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    User findByEmail(String email);
//
//    @Query(value = "SELECT u FROM User u JOIN FETCH u.role r WHERE u.email = :email")
//    User getUserAndRole(@Param("email")String email);
//
//    User findByPhoneNumber(String phoneNumber);
//
//    @Query(value = "SELECT u.* FROM user u INNER JOIN user_role ur ON u.id = ur.user_id INNER JOIN role r ON ur.role_id = r.id " +
//            "WHERE r.name = :userRole",nativeQuery = true)
//    Page<User> findByRole(@Param("userRole")String userRole, Pageable pageable);
//
//    @Query(value = "SELECT u.* FROM user u INNER JOIN user_role ur ON u.id = ur.user_id INNER JOIN role r ON ur.role_id = r.id " +
//            "WHERE r.name = :userRole AND u.name LIKE %:name%",nativeQuery = true)
//    Page<User> findByRoleAndName(@Param("userRole")String userRole, @Param("name")String name, Pageable pageable);
//}
