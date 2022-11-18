package com.example.controller.contract;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.service.ContractService.IAttachFacilityService;
import com.example.service.ContractService.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/attach/v1")
public class AttachController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping()
    public ResponseEntity<List<AttachFacility>> getContractList(){
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        if (attachFacilities.isEmpty()){
            return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
        }
        return new ResponseEntity<>(attachFacilities,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity view(@PathVariable int id) {
        AttachFacility attachFacility = attachFacilityService.findById(id);
        if (attachFacility == null){
            return  new ResponseEntity<>(attachFacility , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attachFacility , HttpStatus.OK);
    }
}
