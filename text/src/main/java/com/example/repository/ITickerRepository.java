package com.example.repository;

import com.example.module.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ITickerRepository extends JpaRepository<Ticker, Integer> {

}
