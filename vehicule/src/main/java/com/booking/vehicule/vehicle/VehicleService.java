package com.booking.vehicule.vehicle;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository repository;
    @Autowired
    VehicleMapper vehicleMapper;

    public List<Vehicle> getVehicles(){
        return repository.findAll();
    }

    public Integer createVehicle( VehicleRequest vehicleRequest) {
        var vehicle= vehicleMapper.toVehicle(vehicleRequest);
        return repository.save(vehicle).getId();
    }
}
