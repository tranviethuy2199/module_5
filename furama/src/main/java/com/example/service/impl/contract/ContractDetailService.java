package com.example.service.impl.contract;

import com.example.model.contract.ContractDetail;
import com.example.repository.ContractRepo.ContractDetailRepo;
import com.example.service.ContractService.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private ContractDetailRepo contractDetailRepo;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepo.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepo.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepo.save(contractDetail);
    }

    @Override
    public void remove(ContractDetail contractDetail) {
        contractDetailRepo.delete(contractDetail);
    }
}
