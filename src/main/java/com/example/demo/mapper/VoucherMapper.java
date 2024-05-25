package com.example.demo.mapper;

import com.example.demo.model.dto.VoucherDto;
import com.example.demo.model.request.VoucherRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoucherMapper {
    Boolean existsByCode(@Param("voucherCode") String voucherCode);

    void create(@Param("voucherInfo") VoucherRequest voucherRequest);

    List<VoucherDto> findAll();

    List<VoucherDto> findVoucherValid();

    VoucherDto findById(@Param("voucherId") Long voucherId);

    void update(@Param("voucherId") Long voucherId, @Param("voucherInfo") VoucherRequest voucherRequest);

    VoucherDto findByCode(@Param("voucherCode") String voucherCode);
}
