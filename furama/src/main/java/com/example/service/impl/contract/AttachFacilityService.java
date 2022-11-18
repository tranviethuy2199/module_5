package com.example.service.impl.contract;

import com.example.model.contract.AttachFacility;
import com.example.repository.ContractRepo.AttachFacilityRepo;
import com.example.service.ContractService.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private AttachFacilityRepo attachFacilityRepo;

    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return attachFacilityRepo.findAll(pageable);
    }

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepo.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepo.findById(id).orElse(null);
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepo.save(attachFacility);
    }

    @Override
    public void remove(AttachFacility attachFacility) {
        attachFacilityRepo.delete(attachFacility);
    }
}
