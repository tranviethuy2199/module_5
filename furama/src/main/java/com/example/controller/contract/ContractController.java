package com.example.controller.contract;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.ContractService.IAttachFacilityService;
import com.example.service.ContractService.IContractDetailService;
import com.example.service.ContractService.IContractService;
import com.example.service.ICustomer.ICustomerService;
import com.example.service.IEmployee.IEmployeeService;
import com.example.service.IFacility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @ModelAttribute("attachFacility")
    public List<AttachFacility> list() {
        return attachFacilityService.findAll();
    }

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;


    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contracts = contractService.findAll(pageable);
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        Contract contract = new Contract();
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contracts", contracts);
        modelAndView.addObject("contractDetails", contractDetails);
        modelAndView.addObject("attachFacilities", attachFacilities);
        modelAndView.addObject("contract", contract);
        return modelAndView;
    }

    @GetMapping("/contract/create")
    public ModelAndView  createContract() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        List<Employee> employees = employeeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Facility> facilities = facilityService.findAll();
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        modelAndView.addObject("contract" , new Contract());
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("attachFacilities", attachFacilities);
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public ModelAndView createContract(@ModelAttribute("contract") Contract contract){
        contractService.save(contract);
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        List<Employee> employees = employeeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Facility> facilities = facilityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("attachFacilities", attachFacilities);
        modelAndView.addObject("contract" , contract);
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("message" , "contract was created");
        return modelAndView;
    }

    @GetMapping("/edit")
    public String showUpdateForm(@ModelAttribute("contract") Contract contract,
                                 RedirectAttributes redirectAttributes) {
        contract = contractService.findById(contract.getId());
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/edit");
        modelAndView.addObject("contract", contract);
        modelAndView.addObject("contractDetails", contractDetails);
        modelAndView.addObject("attachFacilities", attachFacilities);
        redirectAttributes.addFlashAttribute("message", "update OK!");
        return "redirect:/contract";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id ) {
        Contract contract = contractService.findById(id);
        contract.setStatus(0);
        contractService.save(contract);
        return "redirect:/contract";
    }

}
