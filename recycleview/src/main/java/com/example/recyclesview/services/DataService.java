package com.example.recyclesview.services;

import com.example.recyclesview.model.Station;

import java.util.ArrayList;

/**
 * Created by den on 2017-04-26.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations(){
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two-Whelon (Biking Playlist)","bicyclemusic"));
        list.add(new Station("Kids Jams (Music for children)","kidsmusic"));
        return list;
    }

    public ArrayList<Station> getRecentStations(){
        ArrayList<Station> list = new ArrayList<>();
//        list.add(new Station("Flight Plan (Tunes for Travel)","flightplanmusic"));
//        list.add(new Station("Two-Whelon (Biking Playlist)","bicyclemusic"));
//        list.add(new Station("Kids Jams (Music for children)","kidsmusic"));
        return list;
    }

    public ArrayList<Station> getPartyStations(){
        ArrayList<Station> list = new ArrayList<>();
//        list.add(new Station("Flight Plan (Tunes for Travel)","flightplanmusic"));
//        list.add(new Station("Two-Whelon (Biking Playlist)","bicyclemusic"));
//        list.add(new Station("Kids Jams (Music for children)","kidsmusic"));
        return list;
    }
}
