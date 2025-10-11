package com.booking.vehicule.vehicle;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return service.getVehicles();
    }

    @PostMapping
    public ResponseEntity<Integer> addVehicle(@RequestBody @Valid VehicleRequest vehicleRequest){
        return ResponseEntity.ok(service.createVehicle(vehicleRequest));
    }
}
