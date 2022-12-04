package com.example.module;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String garageName;

    @OneToMany(mappedBy = "garage")
    @JsonBackReference
    private Set<Ticker> tickers;

    public Garage() {
    }

    public Garage(int id, String garageName, Set<Ticker> tickers) {
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
