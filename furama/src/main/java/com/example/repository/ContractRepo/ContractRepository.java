package com.example.repository.ContractRepo;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract , Integer> {
    @Query(value = "select * from `contract` where status =1" , nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select `customer`.name , `employee`.name , `facility`.name  , `attach_facility`.name ," +
            " `attach_facility`.cost , `attach_facility`.unit from `contract` " +
            "join `contract_detai`l` on `contract``.id = `contract_detail`.contract_id" +
            "left join `attach_facility` on `attach_facility`.id = `contract_detail`.attach_facility_id" +
            "left join `customer` on `customer`.id = `contract`.customer_id" +
            "left join `employee` on `employee`.id = `contract`.employee_id" +
            "left join `facility` on `facility`.id = `contract`.facility_id" +
            "where `contract`.id = 1 " , nativeQuery = true)
    Contract showAttachFacilityById(int id);

}
