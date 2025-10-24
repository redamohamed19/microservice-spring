package com.booking.order.order;

import com.booking.order.vehicle.Vehicle;

public record OrderResponse(
        OrderStatus status,
        Vehicle vehicle
) {
}
