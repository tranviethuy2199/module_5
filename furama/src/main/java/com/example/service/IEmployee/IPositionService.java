package com.example.service.IEmployee;

import com.example.model.customer.CustomerType;
import com.example.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    Position findById(int id);

    void save(Position position);

    void remove(Position position);
}
