package com.example.autodealer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {

    @Id
    @GeneratedValue
    private long vehicleId;

    private String name;
    private Integer power;
    private Integer capacity;


    @Column
    @Enumerated(EnumType.STRING)
    private GasType gasType;

    @Column
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<RegisteredCar> registeredCars = new ArrayList<>();

}
