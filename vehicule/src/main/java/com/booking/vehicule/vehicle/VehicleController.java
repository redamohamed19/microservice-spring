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

    @GetMapping("/{vehicle-id}")
    public ResponseEntity<Vehicle> findVehicleById(@PathVariable("vehicle-id") Integer id){

        return ResponseEntity.ok(service.findVehicleById(id));
    }

   @PutMapping("/{vehicle-id}")
   public ResponseEntity<Vehicle> updateVehicle(@PathVariable("vehicle-id") Integer id, @RequestBody VehicleRequest vehicleRequest){

        return ResponseEntity.ok(service.updateVehicle(id,vehicleRequest));
   }


    @DeleteMapping("/{vehicle-id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicle-id") Integer id){
          service.deleteVehicle(id);
          return ResponseEntity.accepted().build();
    }
}
