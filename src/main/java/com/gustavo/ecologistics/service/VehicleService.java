package com.gustavo.ecologistics.service;

import com.gustavo.ecologistics.model.Vehicle;
import com.gustavo.ecologistics.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com id "));
    }

    public Vehicle save(Vehicle vehicle){
        return vehicleRepository.save(vehicle);

    }

    public void delete(Long id){
        Vehicle vehicle = findById(id);
        vehicleRepository.delete(vehicle);
    }
}
