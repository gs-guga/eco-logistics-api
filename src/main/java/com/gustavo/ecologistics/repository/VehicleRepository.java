package com.gustavo.ecologistics.repository;

import com.gustavo.ecologistics.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle ,Long> {
}
