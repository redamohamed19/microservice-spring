package com.booking.vehicule.vehicle;

import org.springframework.stereotype.Component;
@Component

public class VehicleMapper {

    public Vehicle toVehicle(VehicleRequest vehicleRequest) {
        return Vehicle.builder().year(vehicleRequest.year()).model(vehicleRequest.model()).build();
    }
}
