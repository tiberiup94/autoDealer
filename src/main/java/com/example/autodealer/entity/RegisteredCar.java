package com.example.autodealer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "cars_registred")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredCar {


    @Id
    @GeneratedValue
    private long registeredCarId;

    private String name;
    private Float price;
    private Float kilometers;

    @Column
    private Date registerOnDate;

    @Column (unique = true)
    private String vIn;


    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false)
    private Vehicle vehicle;

}
