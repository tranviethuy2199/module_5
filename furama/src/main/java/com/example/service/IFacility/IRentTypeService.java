package com.example.service.IFacility;

import com.example.model.employee.Division;
import com.example.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    RentType findById(int id);

    void save(RentType rentType);

    void remove(RentType rentType);
}
