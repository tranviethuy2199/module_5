package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date start_date;
    private Date end_date;
    private double deposit; // đặt cọc
    private Integer status = 1;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private Set<ContractDetail> contractDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;


    public Contract() {
    }

    public Contract(int id, Date start_date, Date end_date, double deposit, Integer status,
                    Set<ContractDetail> contractDetails, Employee employee,
                    Customer customer, Facility facility) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.deposit = deposit;
        this.status = status;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Set<ContractDetail> getContractDetail() {
//        return contractDetail;
//    }
//
//    public void setContractDetail(Set<ContractDetail> contractDetail) {
//        this.contractDetail = contractDetail;
//    }
}
