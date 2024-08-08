package com.example.autodealer.repository;

import com.example.autodealer.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}

