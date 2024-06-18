package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private long id;

    private String name;
    private Integer power;
    private Integer capacity;

//    @Column(unique = true)
//    private String vin;

    @Enumerated(EnumType.STRING)
    private GasType gasType;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Float price;
    private Float kilometers;
    private Date registerOnDate;



}
