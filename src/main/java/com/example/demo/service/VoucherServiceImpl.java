//package com.example.demo.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import com.example.demo.entity.Voucher;
//import com.example.demo.exception.VoucherCodeExistException;
//import com.example.demo.model.dto.VoucherDto;
//import com.example.demo.model.request.VoucherRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.VoucherRepository;
//
//@Service
//@Slf4j
//public class VoucherServiceImpl implements VoucherService{
//    private final VoucherRepository voucherRepository;
//
//    private final ModelMapper modelMapper;
//
//    public VoucherServiceImpl(VoucherRepository voucherRepository, ModelMapper modelMapper) {
//        this.voucherRepository = voucherRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> createVoucher(VoucherRequest voucherRequest) {
//        log.info("Start API: createVoucher with parameters: ({})", voucherRequest);
//        try {
//            if (voucherRepository.existsByCode(voucherRequest.getCode()))
//                throw new VoucherCodeExistException(String.format("Voucher code %s is already exist", voucherRequest.getCode()));
//            Voucher voucher = modelMapper.map(voucherRequest, Voucher.class);
//            voucherRepository.save(voucher);
//            log.info("End API: createVoucher");
//            return new ResponseEntity<>(new ResponseApi<>("Create voucher success", 201), HttpStatus.CREATED);
//        } catch (VoucherCodeExistException e) {
//            log.error("Error API: createVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: createVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<List<VoucherDto>>> getListVoucher() {
//        log.info("Start API: getListVoucher");
//        List<Voucher> listVoucher = voucherRepository.getListVoucher();
//        List<VoucherDto> listVoucherDto = listVoucher.stream().map(voucher -> modelMapper.map(voucher, VoucherDto.class)).toList();
//        log.info("End API: getListVoucher");
//        return new ResponseEntity<>(new ResponseApi<>("Get list voucher success", 200, listVoucherDto), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<List<VoucherDto>>> getAllVoucher() {
//        log.info("Start API: getAllVoucher");
//        List<Voucher> listVoucher = voucherRepository.findAll();
//        List<VoucherDto> listVoucherDto = listVoucher.stream().map(voucher -> modelMapper.map(voucher, VoucherDto.class)).toList();
//        log.info("End API: getAllVoucher");
//        return new ResponseEntity<>(new ResponseApi<>("Get all voucher success", 200, listVoucherDto), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> editVoucher(Long id, VoucherRequest voucherRequest) {
//        log.info("Start API: editVoucher with parameters: (id: {}, {})", id, voucherRequest);
//        try {
//            if (voucherRepository.existsByCode(voucherRequest.getCode()))
//                throw new VoucherCodeExistException(String.format("Voucher code %s is already exist", voucherRequest.getCode()));
//            Voucher voucher = voucherRepository.findById(id).get();
//            modelMapper.map(voucherRequest, voucher);
//            voucherRepository.save(voucher);
//            log.info("End API: editVoucher");
//            return new ResponseEntity<>(new ResponseApi<>("Edit voucher success", 200), HttpStatus.OK);
//        } catch (VoucherCodeExistException e) {
//            log.error("Error API: editVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: editVoucher with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
