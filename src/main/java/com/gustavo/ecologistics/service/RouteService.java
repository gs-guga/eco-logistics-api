package com.gustavo.ecologistics.service;

import com.gustavo.ecologistics.model.Vehicle;
import com.gustavo.ecologistics.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gustavo.ecologistics.model.Route;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private VehicleService vehicleService;

    public Route createRoute(Long vehicleId, String origin, String destination, Double distanceKm) {

        Vehicle vehicle = vehicleService.findById(vehicleId);

        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistanceKm(distanceKm);
        route.setVehicle(vehicle);

        Double co2Factor = 0.0;

        switch (vehicle.getFuelType()){
            case DIESEL -> co2Factor = 0.9;
            case ELECTRIC -> co2Factor = 0.0;
            default -> co2Factor = 0.2;
        }
        Double totalEmitted = distanceKm * co2Factor;
        route.setCo2Emitted(totalEmitted);

        return routeRepository.save(route);
    }
}