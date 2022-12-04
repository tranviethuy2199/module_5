package com.example.dto;

import com.example.module.Ticker;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class GarageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String garageName;

    @OneToMany(mappedBy = "garage")
    @JsonBackReference
    private Set<Ticker> tickers;

    public GarageDto() {
    }

    public GarageDto(int id, String garageName, Set<Ticker> tickers) {
        this.id = id;
        this.garageName = garageName;
        this.tickers = tickers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public Set<Ticker> getTickers() {
        return tickers;
    }

    public void setTickers(Set<Ticker> tickers) {
        this.tickers = tickers;
    }
}

