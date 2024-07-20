package com.example.demo.mapper;

import com.example.demo.model.dto.SupplierDto;
import com.example.demo.model.request.SupplierRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierMapper {
    void addSupplier(@Param("supplierInfo") SupplierRequest supplierRequest);

    List<SupplierDto> getListSupplier();

    void updateSupplier(@Param("supplierId") Long supplierId, @Param("supplierInfo") SupplierRequest supplierRequest);

    void deleteSupplier(@Param("supplierId")Long supplierId);
}
