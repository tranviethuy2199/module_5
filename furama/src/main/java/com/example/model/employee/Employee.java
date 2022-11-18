package com.example.model.employee;

import com.example.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private int idCard;
    private String phoneNumber;
    private String email;
    private double salary;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "educationDegree_id" , referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "division_id" , referencedColumnName = "id")
    private Division division;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id" , referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;


    public Employee() {
    }

    public Employee(Integer id, String name, Date dateOfBirth, int idCard,
                    String phoneNumber, String email, double salary,
                    String address, EducationDegree educationDegree, Division division, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.educationDegree = educationDegree;
        this.division = division;
        this.position = position;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
