package com.aleksB.gifrategenerator.service;

import com.aleksB.gifrategenerator.models.OpenExchangeRate;
import com.aleksB.gifrategenerator.service.client.ExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GetRatesService {

    @Value("${aleksB.app.app_id}")
    private String app_id;

    @Autowired
    ExchangeClient exchangeClient;

    public String getDate(String day) {
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (day.equals("today")) {
            LocalDateTime today = LocalDateTime.now();
            return frmt.format(today);
        } else {
            LocalDateTime today = LocalDateTime.now();
            LocalDateTime yesterday = today.minusDays(1);
            return frmt.format(yesterday);
        }
    }
     public double getRates(String day){
        if(day.equals("today")){
            OpenExchangeRate result = exchangeClient.getTodayRates(app_id);
            return result.getRates().get("RUB");
        } else {
            OpenExchangeRate result = exchangeClient.getYesterdayRates(app_id, getDate("yesterday"));
            return result.getRates().get("RUB");
        }

        }
}
