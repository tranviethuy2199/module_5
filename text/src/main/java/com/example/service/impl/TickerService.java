package com.example.service.impl;

import com.example.module.Ticker;
import com.example.repository.ITickerRepository;
import com.example.service.ITickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerService implements ITickerService {

    @Autowired
    private ITickerRepository tickerRepository;


    @Override
    public List<Ticker> findAll() {
        return tickerRepository.findAll();
    }

    @Override
    public Ticker findById(int id) {
        return tickerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Ticker ticker) {
        tickerRepository.save(ticker);
    }

    @Override
    public void remove(Ticker ticker) {
        tickerRepository.delete(ticker);
    }

    @Override
    public Page<Ticker> findAll(Pageable pageable) {
        return tickerRepository.findAll(pageable);
    }
}
