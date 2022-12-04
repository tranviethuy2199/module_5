package com.example.controller;

import com.example.module.Garage;
import com.example.module.Ticker;
import com.example.repository.IGarageRepository;
import com.example.service.IGarageService;
import com.example.service.ITickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ticker")
public class TickerController {

    @Autowired
    ITickerService tickerService;

    @Autowired
    IGarageService garageService;

    @GetMapping("")
    public ModelAndView showTicker(@PageableDefault(value = 3)Pageable pageable){
        Page<Ticker> tickers = tickerService.findAll(pageable);
        List<Garage> garages = garageService.findAll();
        ModelAndView modelAndView = new ModelAndView("/ticker/index");
        modelAndView.addObject("tickers",tickers);
        modelAndView.addObject("garages",garages);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        List<Garage> garages = garageService.findAll()
    }
}
