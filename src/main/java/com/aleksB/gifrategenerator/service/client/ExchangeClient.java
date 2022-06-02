package com.aleksB.gifrategenerator.service.client;

import com.aleksB.gifrategenerator.models.OpenExchangeRate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="exchange-client", url="${aleksB.app.exchangeURL}")
public interface ExchangeClient {

    @GetMapping("/latest.json")
    OpenExchangeRate getTodayRates(@RequestParam("app_id") String appId);

    @GetMapping("historical/{date}.json")
    OpenExchangeRate getYesterdayRates(@RequestParam("app_id") String appId, @PathVariable String date);

}
