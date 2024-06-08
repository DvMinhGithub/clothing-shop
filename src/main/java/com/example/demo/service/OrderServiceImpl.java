package com.example.demo.service;

import java.security.Principal;
import java.util.List;

import com.example.demo.enums.OrderStatus;
import com.example.demo.mapper.*;
import com.example.demo.model.dto.*;
import com.example.demo.model.request.CreatePaymentRequest;
import com.example.demo.model.request.WebhookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.response.ResponseApi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

    private final CartMapper cartMapper;

    private final OrderMapper orderMapper;

    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    private final PaymentService paymentService;

    private final VoucherMapper voucherMapper;

    public OrderServiceImpl(OrderMapper orderMapper,
                            CartMapper cartMapper,
                            UserMapper userMapper,
                            ProductMapper productMapper,
                            PaymentService paymentService,
                            VoucherMapper voucherMapper) {
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.paymentService = paymentService;
        this.voucherMapper = voucherMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createOrder(Principal principal, CreateOrderRequest createOrderRequest) {
        log.info("Start API: createOrder with parameters: ({})", createOrderRequest);
        UserDto user = userMapper.getByEmail(principal.getName());
        List<CartItemDto> listCartItem = cartMapper.getByCartItemId(createOrderRequest.getListCartItemId());
        VoucherDto voucherDto = voucherMapper.findByCode(createOrderRequest.getVoucherCode());

        double totalPrice = Math.ceil(listCartItem.stream()
                .mapToDouble(item -> item.getProductPrice() * item.getQuantity())
                .sum() - voucherDto.getDiscountPrice());

        //Tạo order
        OrderDto orderDto = OrderDto.builder()
                .address(createOrderRequest.getAddress())
                .phoneNumber(createOrderRequest.getPhoneNumber())
                .totalPrice(totalPrice)
                .voucherCode(createOrderRequest.getVoucherCode())
                .userId(user.getId())
                .build();
        orderMapper.create(orderDto);

        CreatePaymentRequest createPaymentRequest = CreatePaymentRequest.builder()
                .orderCode(orderDto.getId())
                .amount((int) totalPrice)
                .description(String.format("Payment for orderId %s", orderDto.getId()))
                .build();

        CreatePaymentDto createPaymentDto = paymentService.createPayment(createPaymentRequest);

        orderMapper.setCheckOutUrl(orderDto.getId(), createPaymentDto != null ? createPaymentDto.getData().getCheckoutUrl() : null);

        for (CartItemDto cartItemDto : listCartItem) {
            //Tạo order item
            OrderItemDto orderItemDto = OrderItemDto.builder()
                    .orderId(orderDto.getId())
                    .priceAtOrderTime(cartItemDto.getProductPrice())
                    .productId(cartItemDto.getProductId())
                    .quantity(cartItemDto.getQuantity())
                    .build();
            orderMapper.createOrderItem(orderItemDto);

            //Cập nhật số lượng trong kho
            productMapper.updateInventoryAfterOrder(cartItemDto.getQuantity(), cartItemDto.getProductId());

            //Update số lượng sản phẩm đã bán
            productMapper.updateSoldQuantity(cartItemDto.getQuantity(), cartItemDto.getProductId());
        }

        //Xoá cartItem cũ
        List<Long> listCartItemId = listCartItem.stream().map(CartItemDto::getId).toList();
        cartMapper.deleteListCartItem(listCartItemId);

        log.info("End API: createOrder");
        return new ResponseEntity<>(new ResponseApi<>("Create order success"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> changeOrderStatus(WebhookRequest webhookRequest) {
        log.info("Start API: changeOrderStatus with parameters: ({})", webhookRequest);
        orderMapper.changeOrderStatus(webhookRequest.getData().getOrderCode(), OrderStatus.SUCCESS);
        log.info("End API: changeOrderStatus");
        return new ResponseEntity<>(new ResponseApi<>("Change order status success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> cancelOrder(Long orderId) {
        log.info("Start API: cancelOrder with parameters: (id: {})", orderId);
        orderMapper.changeOrderStatus(orderId, OrderStatus.CANCEL);
        log.info("End API: cancelOrder");
        return new ResponseEntity<>(new ResponseApi<>("Change order status success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(Principal principal, OrderStatus orderStatus) {
        log.info("Start API: getListOrder");
        UserDto user = userMapper.getByEmail(principal.getName());
        List<OrderDetailDto> listOrder = orderMapper.getListOrder(user.getId(), orderStatus);
        log.info("End API: getListOrder");
        return new ResponseEntity<>(new ResponseApi<>("Get list order success", listOrder), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<OrderDetailDto>> getOrderDetail(Long orderId){
        log.info("Start API: getOrderDetail with parameters: (id: {})", orderId);
        OrderDetailDto orderDetail = orderMapper.getOrderDetail(orderId);
        log.info("End API: getOrderDetail");
        return new ResponseEntity<>(new ResponseApi<>("Get order detail success", orderDetail), HttpStatus.OK);
    }
}
