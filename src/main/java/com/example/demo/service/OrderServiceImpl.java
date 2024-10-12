package com.example.demo.service;

import com.example.demo.enums.OrderStatus;
import com.example.demo.exception.ProductNotAvailableToBuyException;
import com.example.demo.mapper.*;
import com.example.demo.model.dto.*;
import com.example.demo.model.request.CreatePaymentRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.response.ResponseApi;

import com.example.demo.utils.MethodUtils;
import com.example.demo.utils.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

    private final CartMapper cartMapper;

    private final OrderMapper orderMapper;

    private final ProductMapper productMapper;

    private final PaymentService paymentService;

    private final VoucherMapper voucherMapper;

    private final SecurityUtils securityUtils;

    public OrderServiceImpl(OrderMapper orderMapper,
                            CartMapper cartMapper,
                            ProductMapper productMapper,
                            PaymentService paymentService,
                            VoucherMapper voucherMapper,
                            SecurityUtils securityUtils) {
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.paymentService = paymentService;
        this.voucherMapper = voucherMapper;
        this.securityUtils = securityUtils;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> createOrder(CreateOrderRequest createOrderRequest) {
        log.info("Start API: createOrder with parameters: (createOrderRequest: {})", createOrderRequest);
        Long userId = securityUtils.getUserLoggedInId();
        List<CartItemDto> listCartItem = cartMapper.getByCartItemId(createOrderRequest.getListCartItemId());
        listCartItem.forEach(item -> {
            if(item.getProductSold() + item.getQuantity() > item.getQuantityInStock()){
                throw new ProductNotAvailableToBuyException(String.format("Product id%s is not enough to order", item.getProductId()));
            }
        });

        VoucherDto voucherDto = voucherMapper.findByCode(createOrderRequest.getVoucherCode());

        double discountPrice = voucherDto == null ? 0 : voucherDto.getDiscountPrice();
        double totalPrice = Math.ceil(listCartItem.stream()
                .mapToDouble(item -> item.getProductPriceAfterDiscount() * item.getQuantity())
                .sum() - discountPrice);

        //Tạo order
        long orderCode = Long.parseLong(MethodUtils.generateOrderCode());
        OrderDto orderDto = OrderDto.builder()
                .orderCode(orderCode)
                .address(createOrderRequest.getAddress())
                .phoneNumber(createOrderRequest.getPhoneNumber())
                .totalPrice(totalPrice)
                .voucherCode(createOrderRequest.getVoucherCode())
                .userId(userId)
                .build();
        orderMapper.create(orderDto);

        CreatePaymentRequest createPaymentRequest = CreatePaymentRequest.builder()
                .orderCode(orderCode)
                .amount((int) totalPrice)
                .description(String.format("Payment for orderId %s", orderDto.getId()))
                .build();

        CreatePaymentDto createPaymentDto = paymentService.createPayment(createPaymentRequest);

        orderMapper.setCheckOutUrl(orderDto.getId(), createPaymentDto != null ? createPaymentDto.getData().getCheckoutUrl() : null);

        for (CartItemDto cartItemDto : listCartItem) {
            //Tạo order item
            OrderItemDto orderItemDto = OrderItemDto.builder()
                    .orderId(orderDto.getId())
                    .priceAtOrderTime(cartItemDto.getProductPriceAfterDiscount())
                    .productId(cartItemDto.getProductId())
                    .quantity(cartItemDto.getQuantity())
                    .build();
            orderMapper.createOrderItem(orderItemDto);

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
        log.info("Start API: changeOrderStatus with parameters: (webhookRequest: {})", webhookRequest);
        orderMapper.changeOrderStatus(webhookRequest.getData().getOrderCode(), OrderStatus.SUCCESS);
        log.info("End API: changeOrderStatus");
        return new ResponseEntity<>(new ResponseApi<>("Change order status success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> cancelOrder(Long orderCode) {
        log.info("Start API: cancelOrder with parameters: (orderCode: {})", orderCode);
        orderMapper.changeOrderStatus(orderCode, OrderStatus.CANCEL);
        log.info("End API: cancelOrder");
        return new ResponseEntity<>(new ResponseApi<>("Change order status success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(OrderStatus orderStatus) {
        log.info("Start API: getListOrder");
        Long userId = securityUtils.getUserLoggedInId();
        List<OrderDetailDto> listOrder = orderMapper.getListOrder(userId, orderStatus);
        log.info("End API: getListOrder");
        return new ResponseEntity<>(new ResponseApi<>("Get list order success", listOrder), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<OrderDetailDto>> getOrderDetail(Long orderId) {
        log.info("Start API: getOrderDetail with parameters: (id: {})", orderId);
        OrderDetailDto orderDetail = orderMapper.getOrderDetail(orderId);
        log.info("End API: getOrderDetail");
        return new ResponseEntity<>(new ResponseApi<>("Get order detail success", orderDetail), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<StatisticOrderDto>> getStatisticOrder(){
        log.info("Start API: getStatisticOrder");
        StatisticOrderDto statisticOrderDto = new StatisticOrderDto();
        statisticOrderDto.setTotalOrder(orderMapper.getTotalOrder());
        statisticOrderDto.setOrderPending(orderMapper.getOrderPending());
        statisticOrderDto.setOrderSuccess(orderMapper.getOrderSuccess());
        statisticOrderDto.setOrderCancel(orderMapper.getOrderCancel());
        log.info("End API: getStatisticOrder");
        return new ResponseEntity<>(new ResponseApi<>("Get statistic order success", statisticOrderDto), HttpStatus.OK);
    }
}
