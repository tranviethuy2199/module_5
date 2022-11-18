package com.example.service.IEmployee;

import com.example.model.customer.CustomerType;
import com.example.model.employee.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();

    Division findById(int id);

    void save(Division division);

    void remove(Division division);
}
