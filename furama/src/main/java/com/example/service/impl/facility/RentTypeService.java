package com.example.service.impl.facility;

import com.example.model.facility.RentType;
import com.example.repository.FacilityRepo.RentTypeRepository;
import com.example.service.IFacility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;


    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(RentType rentType) {
        rentTypeRepository.delete(rentType);
    }
}
