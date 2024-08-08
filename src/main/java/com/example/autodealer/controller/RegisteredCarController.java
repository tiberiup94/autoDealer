package com.example.autodealer.controller;


import com.example.autodealer.entity.Model;
import com.example.autodealer.entity.RegisteredCar;
import com.example.autodealer.entity.RegisteredCarDTO;
import com.example.autodealer.entity.Vehicle;
import com.example.autodealer.service.RegisteredCarService;
import com.example.autodealer.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/register/car")
@CrossOrigin(origins = "*")
public class RegisteredCarController {

    private final VehicleService vehicleService;
    private RegisteredCarService registeredCarService;

    public RegisteredCarController(RegisteredCarService registeredCarService, VehicleService vehicleService) {
        this.registeredCarService = registeredCarService;
        this.vehicleService = vehicleService;
    }


    @PostMapping("/add")
    public String registerCar(@RequestBody RegisteredCar registeredCar) {
        return registeredCarService.addRegisterCar(registeredCar);
    }


    @GetMapping("/getAll")
    public List<RegisteredCar> getAllRegisteredCars() {
        return registeredCarService.getAllRegisteredCars();
    }

    @GetMapping("/getAllDTO")
    public List<RegisteredCarDTO> getAllRegisteredCarsDTO() {
        List<RegisteredCar> registeredCars = registeredCarService.getAllRegisteredCars();
        return registeredCars.stream().map(RegisteredCarDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/addDTO")
    public RegisteredCarDTO registerCar(@RequestBody RegisteredCarDTO registeredCarDTO) {
        RegisteredCar registeredCar = new RegisteredCar();
        registeredCar.setName(registeredCarDTO.getName());
        registeredCar.setKilometers(registeredCarDTO.getKilometers());
        registeredCar.setPrice(registeredCarDTO.getPrice());
        registeredCar.setRegisterOnDate(registeredCarDTO.getRegisterOnDate());
        registeredCar.setVIn(registeredCarDTO.getVin());
        Vehicle vehicle = vehicleService.getVehicleById(registeredCarDTO.getVehicleId());
        registeredCar.setVehicle(vehicle);

        registeredCarService.addRegisterCar(registeredCar);
        return new RegisteredCarDTO(registeredCar);

    }

    @GetMapping("/getById/{registeredCarId}")
    public RegisteredCar getRegisteredCarById(@PathVariable (name = "registeredCarId") Long id){
        return registeredCarService.getRegisteredCarById(id);
    }


    @GetMapping("/getDTO/{id}")
    public RegisteredCarDTO getCarById(@PathVariable Long id) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(id);
        return new RegisteredCarDTO(registeredCar);
    }

    @DeleteMapping("/delete/{registeredCarId}")
    public boolean deleteRegisteredCar(@PathVariable (name = "registeredCarId") Long id) {
        return registeredCarService.deleteRegisteredCarById(id);
    }

    @PutMapping("/update")
    public boolean updateRegisteredCar(@RequestBody RegisteredCar registeredCar) {
        return registeredCarService.updateRegisteredCar(registeredCar);
    }


}
