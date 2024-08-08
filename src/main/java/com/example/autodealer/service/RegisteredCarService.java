package com.example.autodealer.service;


import com.example.autodealer.entity.Model;
import com.example.autodealer.entity.RegisteredCar;
import com.example.autodealer.repository.RegisteredCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegisteredCarService {

    private RegisteredCarRepository registeredCarRepository;

    public RegisteredCarService(RegisteredCarRepository registeredCarRepository) {
        this.registeredCarRepository = registeredCarRepository;
    }

    public String addRegisterCar(RegisteredCar registeredCar) {
        registeredCarRepository.save(registeredCar);
        return "Registered car added";
    }


    public List<RegisteredCar> getAllRegisteredCars() {
        return registeredCarRepository.findAll();
    }


    public RegisteredCar getRegisteredCarById(Long id) {

        return registeredCarRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public boolean deleteRegisteredCarById(Long id) {

        RegisteredCar optional = registeredCarRepository.findById(id).orElseThrow(NoSuchElementException::new);
        registeredCarRepository.delete(optional);
        return true;


    }

    public boolean updateRegisteredCar(RegisteredCar registeredCar) {

        Optional<RegisteredCar> existingCar = registeredCarRepository.findById(registeredCar.getRegisteredCarId());
        if (existingCar.isPresent()) {
            registeredCarRepository.save(registeredCar);
            return true;
        } else {
            return false;
        }


    }
}