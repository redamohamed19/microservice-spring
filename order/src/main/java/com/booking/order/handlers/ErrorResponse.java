package com.booking.order.handlers;


import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}