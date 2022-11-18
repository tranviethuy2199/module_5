package com.example.service.impl.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.ContractRepo.ContractDetailRepo;
import com.example.repository.ContractRepo.ContractRepository;
import com.example.service.ContractService.IContractDetailService;
import com.example.service.ContractService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private ContractRepository contractRepository;


    @Override
    public List<Contract> findAll() {
       return contractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract showAttachFacilityById(int id) {
        return contractRepository.showAttachFacilityById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
