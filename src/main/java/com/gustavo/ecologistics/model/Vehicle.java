package com.gustavo.ecologistics.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_vehicles")
@Getter
@Setter

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private Double capacityKg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FuelType fuelType;
}
