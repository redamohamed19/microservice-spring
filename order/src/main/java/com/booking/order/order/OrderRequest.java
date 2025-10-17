package com.booking.order.order;

import jakarta.validation.constraints.NotNull;

public record OrderRequest(
    @NotNull
    OrderStatus status
) {
}
