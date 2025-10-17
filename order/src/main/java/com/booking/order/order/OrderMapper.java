package com.booking.order.order;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest){
    return Order.builder().status(orderRequest.status()).build();
}
}
