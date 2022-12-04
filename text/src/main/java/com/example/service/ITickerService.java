package com.example.service;

import com.example.module.Ticker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITickerService{


    List<Ticker> findAll();

    Ticker findById(int id);

    void save(Ticker ticker);

    void remove(Ticker ticker);

    Page<Ticker> findAll(Pageable pageable);

//    List<Ticker> findByName(String name);
}
