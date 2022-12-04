package com.example.service.impl;

import com.example.module.Garage;
import com.example.repository.IGarageRepository;
import com.example.service.IGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements IGarageService {

    @Autowired
    IGarageRepository garageRepository;


    @Override
    public List<Garage> findAll() {
        return garageRepository.findAll();
    }

    @Override
    public Garage findById(int id) {
        return garageRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Garage garage) {
        garageRepository.save(garage);
    }

    @Override
    public void remove(Garage garage) {
        garageRepository.delete(garage);
    }
}
