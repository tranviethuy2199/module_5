package com.example.service.ContractService;

import com.example.model.contract.ContractDetail;
import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail findById(int id);

    void save(ContractDetail contractDetail);

    void remove(ContractDetail contractDetail);
}
