package com.example.model.facility;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Facility implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = "không được để trống")
    private String name;
//    @NotBlank(message = "không được để trống")
    private double area;
//    @NotBlank(message = "không được để trống")
    private double cost;
//    @NotBlank(message = "không được để trống")
    private int amount;
//    @NotBlank(message = "không được để trống")
    private String convenience; // tiện nghi - room and villa
//    @NotBlank(message = "không được để trống")
    private Integer floors;
//    @NotBlank(message = "không được để trống")
    private String facility_free; // dịch vụ miễn phí đi kèm - room
//    @NotBlank(message = "không được để trống")
    private String pool_area; // diện tích hồ bơi - villa
    private Integer status = 1;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="facilityType_id" , referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rentType_id" , referencedColumnName = "id")
    private RentType rentType;

//    @OneToOne(mappedBy = "facility")
//    private Contract contract;

    public Facility() {
    }

    public Facility(Integer id, String name, double area, double cost, int amount,
                    String convenience, Integer floors, String facility_free,
                    String pool_area, Integer status, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.amount = amount;
        this.convenience = convenience;
        this.floors = floors;
        this.facility_free = facility_free;
        this.pool_area = pool_area;
        this.status = status;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }

    public String getPool_area() {
        return pool_area;
    }

    public void setPool_area(String pool_area) {
        this.pool_area = pool_area;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
