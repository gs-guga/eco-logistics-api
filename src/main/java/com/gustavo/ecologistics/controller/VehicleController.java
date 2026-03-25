package com.gustavo.ecologistics.controller;

import com.gustavo.ecologistics.model.Vehicle;
import com.gustavo.ecologistics.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> listALL(){
        return vehicleRepository.findAll();
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
}
