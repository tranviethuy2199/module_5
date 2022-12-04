package com.example.repository;

import com.example.module.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGarageRepository extends JpaRepository<Garage, Integer> {
}
