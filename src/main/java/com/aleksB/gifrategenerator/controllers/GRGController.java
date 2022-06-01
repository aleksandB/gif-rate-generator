package com.aleksB.gifrategenerator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GRGController {
    private static final Logger logger = LoggerFactory.getLogger(GRGController.class);

    @GetMapping("/index")
    public String showMainPage(){
        return "index";
    }

}
