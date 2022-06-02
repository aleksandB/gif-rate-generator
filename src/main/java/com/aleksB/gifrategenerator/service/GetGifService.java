package com.aleksB.gifrategenerator.service;

import com.aleksB.gifrategenerator.models.GifData;
import com.aleksB.gifrategenerator.service.client.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

@Service
public class GetGifService {

    @Value("${aleksB.app.giphyKey}")
    private String api_key;

    @Autowired
    GiphyClient giphyClient;

    public String getURI(String q) {
        try {
            GifData gifData = giphyClient.getTodayRates(api_key, q, 25, 0, "g", "en");
            String gifLink = gifData.getData().get(new Random().nextInt(gifData.getData().size()-1)).getImages().get("original").get("url");
            return gifLink;
        } catch (Exception e) {
            StringWriter stringWriter= new StringWriter();
            PrintWriter printWriter= new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            return stringWriter.toString();
        }
    }
}
