package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cars_registred")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistredCar {


    @Id
    @GeneratedValue
    private long registeredCarId;

    private String name;
    private Float price;
    private Float kilometers;
    private Date registerOnDate;

    @Column (unique = true)
    private String vIn;


    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

}
