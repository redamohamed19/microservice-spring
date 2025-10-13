package com.booking.vehicule.vehicle;

import jakarta.validation.constraints.NotNull;

public record VehicleRequest(
        @NotNull(message = "model is required")
        VehicleModel model,
        @NotNull(message = "year is required")
        Integer year
) {
}
