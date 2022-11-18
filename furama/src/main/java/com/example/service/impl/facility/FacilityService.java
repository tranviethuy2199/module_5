package com.example.service.impl.facility;

import com.example.model.facility.Facility;
import com.example.repository.FacilityRepo.FacilityRepository;
import com.example.service.IFacility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Facility facility) {
        facilityRepository.delete(facility);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

//    @Override
    public Page<Facility> findFacilityByName(String name, String type, Pageable pageable) {
        return facilityRepository.findFacilityByName(name, type, pageable);
    }
}
