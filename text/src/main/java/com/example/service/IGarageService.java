package com.example.service;

import com.example.module.Garage;

import java.util.List;

public interface IGarageService {

    List<Garage> findAll();

    Garage findById(int id);

    void save(Garage garage);

    void remove(Garage garage);
}
