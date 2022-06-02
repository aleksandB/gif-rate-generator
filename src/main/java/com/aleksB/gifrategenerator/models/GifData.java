package com.aleksB.gifrategenerator.models;

import java.util.ArrayList;

public class GifData {
    private ArrayList<DataObj> data = new ArrayList<>();

    public GifData() {
    }

    public ArrayList<DataObj> getData() {
        return data;
    }

    public void setData(ArrayList<DataObj> data) {
        this.data = data;
    }
}

