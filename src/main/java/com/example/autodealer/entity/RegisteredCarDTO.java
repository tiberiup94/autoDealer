package com.example.autodealer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class RegisteredCarDTO {

    @Id
    @GeneratedValue
    private Long registeredCarId;
    private String name;
    private Float price;
    private Float kilometers;
    private Date registerOnDate;
    private String vin;
    private Long vehicleId;

    public RegisteredCarDTO(RegisteredCar registeredCar) {
        this.registeredCarId = registeredCar.getRegisteredCarId();
        this.name = registeredCar.getName();
        this.price = registeredCar.getPrice();
        this.kilometers = registeredCar.getKilometers();
        this.registerOnDate = registeredCar.getRegisterOnDate();
        this.vin = registeredCar.getVIn();
        this.vehicleId = registeredCar.getVehicle().getVehicleId();

    }
}
