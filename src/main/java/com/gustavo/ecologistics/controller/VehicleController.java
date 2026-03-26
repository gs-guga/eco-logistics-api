package com.gustavo.ecologistics.controller;

import com.gustavo.ecologistics.model.Vehicle;
import com.gustavo.ecologistics.repository.VehicleRepository;
import com.gustavo.ecologistics.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> listALL() {
        return vehicleService.findAll();
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getBYId(@PathVariable Long id) {
        return vehicleService.findById(id);

    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle vehicleDetails){
        Vehicle vehicle = vehicleService.findById(id);


        vehicle.setLicensePlate(vehicleDetails.getLicensePlate());
        vehicle.setFuelType(vehicleDetails.getFuelType());
        vehicle.setCapacityKg(vehicleDetails.getCapacityKg());
        vehicle.setModelName(vehicleDetails.getModelName());

        return vehicleService.save(vehicle);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.findById(id);
        vehicleService.delete(id);
    }

}