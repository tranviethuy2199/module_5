package com.example.service.ICustomer;

import com.example.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService   {
    List<CustomerType> findAll();

    CustomerType findById(int id);

    void save(CustomerType customerType);

    void remove(CustomerType customerType);
}
