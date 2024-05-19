//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entity.Voucher;
//
//import java.util.List;
//
//@Repository
//public interface VoucherRepository extends JpaRepository<Voucher, Long> {
//    Boolean existsByCode(String code);
//
//    @Query(value = "SELECT v.* FROM voucher v WHERE v.start_time < NOW() AND v.end_time > NOW()", nativeQuery = true)
//    List<Voucher> getListVoucher();
//}
