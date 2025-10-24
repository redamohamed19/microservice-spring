package com.booking.order.order;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){

        return ResponseEntity.ok(orderService.getOrders());

    }
    @GetMapping("/{order-id}")
    public ResponseEntity<Optional<OrderResponse>> getOrderById(@PathVariable("order-id") Integer id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }


}
