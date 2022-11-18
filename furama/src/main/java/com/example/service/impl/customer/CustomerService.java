package com.example.service.impl.customer;

import com.example.model.customer.Customer;
import com.example.repository.CustomerRepo.ICustomerRepository;
import com.example.service.ICustomer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @Override
    public Page<Customer> findCustomerByName(String name ,
                                             String email ,
                                             String type , Pageable pageable) {
        return customerRepository.findCustomerByName(name,email,type , pageable);
    }
}
