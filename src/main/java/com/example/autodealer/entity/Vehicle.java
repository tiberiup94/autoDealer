package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
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



    @Enumerated(EnumType.STRING)
    private GasType gasType;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Float price;
    private Float kilometers;
    private Date registerOnDate;


    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "vehicle")
    private List<RegistredCar> registredCars = new ArrayList<>();

}
