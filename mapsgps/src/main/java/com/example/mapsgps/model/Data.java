package com.example.mapsgps.model;

/**
 * Created by den on 2017-04-29.
 */

public class Data {

    private float longitude,latitude;
    private String locationTitle,locationAddress,locationImrUrl;

    public Data(float longitude, float latitude, String locationTitle, String locationAddress, String locationImrUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationTitle = locationTitle;
        this.locationAddress = locationAddress;
        this.locationImrUrl = locationImrUrl;
    }
}
