package com.booking.order.order;

import com.booking.order.vehicle.Vehicle;
import com.booking.order.vehicle.VehicleServiceClient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private VehicleServiceClient vehicleServiceClient;

    @Autowired
    private  OrderMapper orderMapper;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Integer createOrder(OrderRequest orderRequest) {

        Vehicle vehicle=vehicleServiceClient.getVehicleByOrderId(orderRequest.vehicle_id())
                .orElseThrow(()-> new EntityNotFoundException("Vehicle not Found with ID:"+orderRequest.vehicle_id()));

            return orderRepository.save(orderMapper.toOrder(orderRequest)).getId();
    }

    public Optional<OrderResponse> getOrderById(Integer id) {
        Vehicle vehicle= vehicleServiceClient.getVehicleByOrderId(id)
                .orElseThrow(()-> new EntityNotFoundException("Vehicle not Found with ID:"+id));;
        return orderRepository.findById(id).map(order -> orderMapper.toOrderResponse(order,vehicle));
    }
}
