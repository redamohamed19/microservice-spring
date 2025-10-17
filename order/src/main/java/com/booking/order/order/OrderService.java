package com.booking.order.order;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private  OrderMapper orderMapper;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Integer createOrder(OrderRequest orderRequest) {
        return orderRepository.save(orderMapper.toOrder(orderRequest)).getId();
    }
}
