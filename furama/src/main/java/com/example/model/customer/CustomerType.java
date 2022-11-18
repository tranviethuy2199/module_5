package com.example.model.customer;

import com.example.model.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class CustomerType{
    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    private Set<Customer> customer;


    public CustomerType() {
    }

    public CustomerType(Integer id, String name, Set<Customer> customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
