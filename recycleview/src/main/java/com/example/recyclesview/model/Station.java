package com.example.recyclesview.model;

/**
 * Created by den on 2017-04-26.
 */

public class Station {
    final String DRAWABLE = "drawable/";
    private String stationTitle;
    private String imageUri;

    public Station(String stationTitle, String imageUri) {
        this.stationTitle = stationTitle;
        this.imageUri = imageUri;
    }

    public String getDRAWABLE() {
        return DRAWABLE;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImageUri() {
        return DRAWABLE+imageUri;
    }
}
