//package com.example.demo.service;
//
//import java.security.Principal;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.entity.CartItem;
//import com.example.demo.entity.Order;
//import com.example.demo.entity.OrderItem;
//import com.example.demo.entity.Product;
//import com.example.demo.entity.ProductInventory;
//import com.example.demo.entity.User;
//import com.example.demo.model.request.CreateOrderRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.CartItemRepository;
//import com.example.demo.repository.OrderItemRepository;
//import com.example.demo.repository.OrderRepository;
//import com.example.demo.repository.ProductInventoryRepository;
//import com.example.demo.repository.ProductRepository;
//import com.example.demo.repository.UserRepository;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class OrderServiceImpl implements OrderService {
//
//    private final OrderRepository orderRepository;
//
//    private final CartItemRepository cartItemRepository;
//
//    private final UserRepository userRepository;
//
//    private final OrderItemRepository orderItemRepository;
//
//    private final ProductInventoryRepository productInventoryRepository;
//
//    private final ProductRepository productRepository;
//
//    public OrderServiceImpl(OrderRepository orderRepository, CartItemRepository cartItemRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, ProductInventoryRepository productInventoryRepository, ProductRepository productRepository) {
//        this.orderRepository = orderRepository;
//        this.cartItemRepository = cartItemRepository;
//        this.userRepository = userRepository;
//        this.orderItemRepository = orderItemRepository;
//        this.productInventoryRepository = productInventoryRepository;
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> createOrder(Principal principal, CreateOrderRequest createOrderRequest) {
//        log.info("Start API: createOrder");
//        User user = userRepository.findByEmail(principal.getName());
//        List<CartItem> listCartItem = cartItemRepository.getListCartItem(createOrderRequest.getListCartItemId());
//
//        double totalPrice = 0.0;
//        Set<OrderItem> listOrderItem = new HashSet<>();
//
//        //Tạo order
//        Order order = new Order();
//        order.setPhoneNumber(createOrderRequest.getPhoneNumber());
//        order.setAddress(createOrderRequest.getAddress());
//        order.setVoucherCode(createOrderRequest.getVoucherCode());
//        order.setUser(user);
//
//        for (CartItem cartItem : listCartItem) {
//            totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
//
//            //Tạo order item
//            OrderItem orderItem = new OrderItem();
//            orderItem.setQuantity(cartItem.getQuantity());
//            orderItem.setPriceAtOrderTime(cartItem.getProduct().getPrice());
//            orderItem.setProduct(cartItem.getProduct());
//            orderItem.setOrder(order);
//            listOrderItem.add(orderItem);
//
//            //Cập nhật số lượng trong kho
//            ProductInventory productInventory = cartItem.getProduct().getProductInventory();
//            productInventory.setQuantity(productInventory.getQuantity() - cartItem.getQuantity());
//            productInventoryRepository.save(productInventory);
//
//            //Cập nhật số lượng đã bán
//            Product product = cartItem.getProduct();
//            product.setSold(cartItem.getProduct().getSold() + cartItem.getQuantity());
//            productRepository.save(product);
//        }
//        //Xoá cartItem cũ
//        List<Long> listCartItemId = listCartItem.stream().map(item -> item.getId()).toList();
//        cartItemRepository.deleteListCartItem(listCartItemId);
//
//        order.setTotalPrice(totalPrice);
//        order.setListOrderItems(listOrderItem);
//        orderRepository.save(order);
//
//        log.info("End API: createOrder");
//        return new ResponseEntity<>(new ResponseApi<>("Create order success", 201), HttpStatus.CREATED);
//    }
//}
