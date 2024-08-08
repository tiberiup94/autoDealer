package com.example.autodealer.repository;

import com.example.autodealer.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface MakeRepository extends JpaRepository<Make, Long> {
}
