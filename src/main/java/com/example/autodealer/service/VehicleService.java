package com.example.autodealer.service;

import com.example.autodealer.entity.Model;
import com.example.autodealer.entity.Vehicle;
import com.example.autodealer.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public String addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "Vehicle added successfully";
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }


    public Vehicle getVehicleById(Long id) {

        return vehicleRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public boolean deleteVehicleById(Long id) {

        Vehicle optional = vehicleRepository.findById(id).orElseThrow(NoSuchElementException::new);
        vehicleRepository.delete(optional);
        return true;


    }

    public boolean updateVehicle(Vehicle vehicle) {

        Vehicle optional = vehicleRepository.findById(vehicle.getVehicleId()).orElseThrow(NoSuchElementException::new);
        optional.setVehicleId(vehicle.getVehicleId());
        optional.setName(vehicle.getName());
        optional.setPower(vehicle.getPower());
        optional.setCapacity(vehicle.getCapacity());
        optional.setModel(vehicle.getModel());
        optional.setGasType(vehicle.getGasType());
        optional.setVehicleType(vehicle.getVehicleType());
        vehicleRepository.save(optional);
        return true;


    }

}
