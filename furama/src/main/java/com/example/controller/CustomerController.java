package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomer.ICustomerService;
import com.example.service.ICustomer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;


    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 3)
                                             Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerTypes", customerTypes);
        modelAndView.addObject("customer", customers);
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypes = customerTypeService.findAll();
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public ModelAndView createBlog(@Validated @ModelAttribute("customer") Customer customer,
                                   BindingResult bindingResult) {
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("customer/create");
            return modelAndView;
        }
        customerService.save(customer);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerTypes", customerTypes);
        modelAndView.addObject("message", "customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("customerTypes", customerTypes);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView update(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("customerTypes" , customerTypes);
        modelAndView.addObject("message" , "Updated customer successfully");
        return modelAndView;
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam int id){
        Customer customer = customerService.findById(id);
        customer.setStatus(0);
        customerService.save(customer);
        return "redirect:/customer";
    }



    @GetMapping("/view-customer/{id}")
    public ModelAndView view(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/find")
    public ModelAndView findbyName(@RequestParam(value = "name") String name ,
                                   @RequestParam(value = "email") String email ,
                                   @RequestParam(value = "type") String type ,@PageableDefault(value = 4) Pageable pageable) {
        Page<Customer> customer = customerService.findCustomerByName(name,email,type , pageable);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("name", name);
        modelAndView.addObject("email", email);
        modelAndView.addObject("type", type);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

}
