package com.example.demo.service;

import com.example.demo.mapper.VoucherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.exception.VoucherCodeExistException;
import com.example.demo.model.dto.VoucherDto;
import com.example.demo.model.request.VoucherRequest;
import com.example.demo.model.response.ResponseApi;

@Service
@Slf4j
public class VoucherServiceImpl implements VoucherService{
    private final VoucherMapper voucherMapper;

    public VoucherServiceImpl(VoucherMapper voucherMapper) {
        this.voucherMapper = voucherMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createVoucher(VoucherRequest voucherRequest) {
        log.info("Start API: createVoucher with parameters: ({})", voucherRequest);
        try {
            if (voucherMapper.existsByCode(voucherRequest.getCode()))
                throw new VoucherCodeExistException(String.format("Voucher code %s is already exist", voucherRequest.getCode()));
            voucherMapper.create(voucherRequest);
            log.info("End API: createVoucher");
            return new ResponseEntity<>(new ResponseApi<>("Create voucher success"), HttpStatus.CREATED);
        } catch (VoucherCodeExistException e) {
            log.error("Error API: createVoucher with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: createVoucher with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<List<VoucherDto>>> getVoucherValid() {
        log.info("Start API: getVoucherValid");
        List<VoucherDto> listVoucher = voucherMapper.findVoucherValid();
        log.info("End API: getVoucherValid");
        return new ResponseEntity<>(new ResponseApi<>("Get list voucher success", listVoucher), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<List<VoucherDto>>> getAllVoucher() {
        log.info("Start API: getAllVoucher");
        List<VoucherDto> listVoucher = voucherMapper.findAll();
        log.info("End API: getAllVoucher");
        return new ResponseEntity<>(new ResponseApi<>("Get all voucher success", listVoucher), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<ResponseApi<?>> editVoucher(Long id, VoucherRequest voucherRequest) {
//        log.info("Start API: editVoucher with parameters: (id: {}, {})", id, voucherRequest);
//        try {
//            VoucherDto voucherDto = voucherMapper.findById(id);
//            if (!voucherRequest.getCode().equals(voucherDto.getCode()) && voucherMapper.existsByCode(voucherRequest.getCode()))
//                throw new VoucherCodeExistException(String.format("Voucher code %s is already exist", voucherRequest.getCode()));
//            voucherMapper.update(id, voucherRequest);
//            log.info("End API: editVoucher");
//            return new ResponseEntity<>(new ResponseApi<>("Edit voucher success"), HttpStatus.OK);
//        } catch (VoucherCodeExistException e) {
//            log.error("Error API: editVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: editVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
