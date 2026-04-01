package com.gustavo.ecologistics.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_routes")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Double distanceKm;

    @Column(nullable = false)
    private Double co2Emitted;

    @ManyToOne
    @JoinColumn(name = "vehicle_id" , nullable = false )
    private Vehicle vehicle;

}
