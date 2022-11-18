package com.example.service.IFacility;

import com.example.model.facility.FacilityType;

import java.util.List;

public interface IStandardRoomService {
    List<FacilityType> findAll();

    FacilityType findById(int id);

    void save(FacilityType standardRoom);

    void remove(FacilityType standardRoom);
}
