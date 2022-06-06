package com.aleksB.gifrategenerator.service.client;

import com.aleksB.gifrategenerator.models.GifData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="giphy-client", url="${aleksB.app.giphyURL}")
public interface GiphyClient {

    @GetMapping()
    GifData getTodayRates(@RequestParam("api_key") String apiKey,
                          @RequestParam("q") String q,
                          @RequestParam("limit") int limit,
                          @RequestParam("offset") int offset,
                          @RequestParam("rating") String rating,
                          @RequestParam("lang") String lang);

}
