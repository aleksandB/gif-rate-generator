package com.aleksB.gifrategenerator.models;

import java.util.Map;

public class DataObj{
    private Map<String, Map<String,String>> images;

    public DataObj() {
    }

    public Map<String, Map<String, String>> getImages() {
        return images;
    }

    public void setImages(Map<String, Map<String, String>> images) {
        this.images = images;
    }
}
