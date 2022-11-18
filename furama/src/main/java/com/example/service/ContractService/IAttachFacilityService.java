package com.example.service.ContractService;

import com.example.model.contract.AttachFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachFacilityService {
    Page<AttachFacility> findAll(Pageable pageable);

    List<AttachFacility> findAll();

    AttachFacility findById(int id);

    void save(AttachFacility attachFacility);

    void remove(AttachFacility attachFacility);
}
