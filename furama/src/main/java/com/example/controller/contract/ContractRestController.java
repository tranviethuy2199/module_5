package com.example.controller.contract;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.service.ContractService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contract/v1")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping()
    public ResponseEntity<List<Contract>> getContractList(){
        List<Contract> contracts = contractService.findAll();
        if (contracts.isEmpty()){
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
        return new ResponseEntity<>(contracts,HttpStatus.OK);
    }


}
