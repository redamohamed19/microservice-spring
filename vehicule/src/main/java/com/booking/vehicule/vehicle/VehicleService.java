package com.booking.vehicule.vehicle;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public void deleteVehicle(Integer id) {
         repository.deleteById(findVehicleById(id).getId());
    }

    public Vehicle findVehicleById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Product Not found with Id:"+id));
    }

    public Vehicle updateVehicle(Integer id, VehicleRequest vehicleRequest) {
        Vehicle vehicle=findVehicleById(id);
        if(StringUtils.hasText(String.valueOf(vehicleRequest.model()))){
            vehicle.setModel(vehicleRequest.model());
        }
        if(vehicleRequest.year() != null){
            vehicle.setYear(vehicleRequest.year());
        }
        return repository.save(vehicle);
    }
}
