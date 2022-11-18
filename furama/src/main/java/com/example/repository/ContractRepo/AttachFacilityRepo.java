package com.example.repository.ContractRepo;

import com.example.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachFacilityRepo extends JpaRepository<AttachFacility , Integer> {

}
