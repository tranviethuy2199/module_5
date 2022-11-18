package com.example.service.impl.employee;

import com.example.model.employee.Position;
import com.example.repository.EmployeeRepo.IPositionRepository;
import com.example.service.IEmployee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Position position) {
        positionRepository.delete(position);
    }
}
