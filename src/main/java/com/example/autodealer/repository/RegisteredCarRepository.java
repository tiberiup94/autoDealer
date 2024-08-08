package com.example.autodealer.repository;

import com.example.autodealer.entity.RegisteredCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredCarRepository extends JpaRepository<RegisteredCar, Long> {
}
