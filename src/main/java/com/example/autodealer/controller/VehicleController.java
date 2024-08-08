package com.example.autodealer.controller;


import com.example.autodealer.entity.Model;
import com.example.autodealer.entity.Vehicle;
import com.example.autodealer.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping("/add")
    public String addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/getAll")
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }


    @GetMapping("/getById/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable (name = "vehicleId") Long id){
        return vehicleService.getVehicleById(id);
    }


    @DeleteMapping("/delete/{vehicleId}")
    public boolean deleteVehicle(@PathVariable (name = "vehicleId") Long id) {
        return vehicleService.deleteVehicleById(id);
    }

    @PutMapping("/update")
    public boolean updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

}
