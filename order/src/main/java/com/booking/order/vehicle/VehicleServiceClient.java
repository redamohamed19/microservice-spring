package com.booking.order.vehicle;

import com.booking.order.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@FeignClient(name = "vehicle-service",
            url = "${application.config.vehicle-url}")
public interface VehicleServiceClient {

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleByOrderId(@PathVariable("id") int id);
}
