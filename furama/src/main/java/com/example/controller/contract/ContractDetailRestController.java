package com.example.controller.contract;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.ContractDetail;
import com.example.service.ContractService.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contractDetail/v1/")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping()
    public ResponseEntity<List<ContractDetail>> getContractDetail() {
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(contractDetails , HttpStatus.OK);
        }
        return new ResponseEntity<>(contractDetails , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity view(@PathVariable int id) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        if (contractDetail == null){
            return  new ResponseEntity<>(contractDetail , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDetail , HttpStatus.OK);
    }
}
