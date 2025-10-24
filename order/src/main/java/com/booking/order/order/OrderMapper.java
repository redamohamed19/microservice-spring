package com.booking.order.order;

import com.booking.order.vehicle.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest){
    return Order.builder().status(orderRequest.status()).vehicle_id(orderRequest.vehicle_id()).build();
}

    public OrderResponse toOrderResponse(Order order, Vehicle vehicle){
        return new OrderResponse(order.getStatus(),vehicle);

    }
}
