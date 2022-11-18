package com.example.service.impl.facility;

import com.example.model.facility.FacilityType;
import com.example.repository.FacilityRepo.StandardRoomRepository;
import com.example.service.IFacility.IStandardRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardRoomService implements IStandardRoomService {

    @Autowired
    private StandardRoomRepository standardRoomRepository;

    @Override
    public List<FacilityType> findAll() {
        return standardRoomRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
        return standardRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void save(FacilityType standardRoom) {
        standardRoomRepository.save(standardRoom);
    }

    @Override
    public void remove(FacilityType standardRoom) {
        standardRoomRepository.delete(standardRoom);
    }
}
