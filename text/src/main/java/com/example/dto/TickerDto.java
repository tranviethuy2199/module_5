package com.example.dto;

import com.example.module.Garage;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class TickerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departure ; // điểm đi
    private String destination; // điểm đến
    private String departureDay ; // ngày khởi hành
    private String departureTime ; // giờ khởi hành
    private double price;
    private int amount ;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "garage_id" , referencedColumnName = "id")
    private Garage garage;


    public TickerDto() {
    }

    public TickerDto(int id, String departure, String destination,
                  String departureDay, String departureTime,
                  double price, int amount, Garage garage) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.departureDay = departureDay;
        this.departureTime = departureTime;
        this.price = price;
        this.amount = amount;
        this.garage = garage;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}

