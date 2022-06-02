package com.aleksB.gifrategenerator.controllers;

import com.aleksB.gifrategenerator.service.GetGifService;
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

    @Autowired
    GetGifService getGifService;

    @GetMapping()
    public String showMainPage(Model model){
        double todayRate = getRatesService.getRates("today");
        double yesterdayRate = getRatesService.getRates("yesterday");
        model.addAttribute("today", getRatesService.getDate("today"));
        model.addAttribute("todayRate", todayRate);
        model.addAttribute("yesterday", getRatesService.getDate("yesterday"));
        model.addAttribute("yesterdayRate", yesterdayRate);
        if(todayRate > yesterdayRate){
            model.addAttribute("uri",getGifService.getURI("rich"));
        } else {
            model.addAttribute("uri",getGifService.getURI("broke"));
        }

        logger.info(getGifService.getURI("rich"));
        return "index";
    }

}
