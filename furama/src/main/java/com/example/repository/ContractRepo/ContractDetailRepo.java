package com.example.repository.ContractRepo;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepo extends JpaRepository<ContractDetail , Integer> {
//    @Query("selec * from contract where start_date like %:date% and status = 1 ")
//    Page<Contract> findContractByDate(@Re)
}
