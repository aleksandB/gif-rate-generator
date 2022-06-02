package com.aleksB.gifrategenerator.controllers;

import com.aleksB.gifrategenerator.service.GetRatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GRGController {
    private static final Logger logger = LoggerFactory.getLogger(GRGController.class);

    @Autowired
    GetRatesService getRatesService;

    @GetMapping("/index")
    public String showMainPage(Model model){
        model.addAttribute("today", getRatesService.getDate("today"));
        model.addAttribute("todayRate", getRatesService.getRates("today"));
        model.addAttribute("yesterday", getRatesService.getDate("yesterday"));
        model.addAttribute("yesterdayRate", getRatesService.getRates("yesterday"));

        return "index";
    }

}
