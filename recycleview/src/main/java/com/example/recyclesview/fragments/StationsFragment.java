package com.example.recyclesview.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclesview.R;
import com.example.recyclesview.adapters.StationsAdapter;
import com.example.recyclesview.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {

    private static final String ARG_STATION_TYPE = "station_type";

    private int stationType;
    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY  = 2;
    public StationsFragment() {
        // Required empty public constructor
    }


    public static StationsFragment newInstance(int stationtype) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationtype);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stations,container,false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);//use fixed size of recyclers view to increase speed
        StationsAdapter stationsAdapter = null;
        switch (stationType){
            case STATION_TYPE_FEATURED:
                stationsAdapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
                break;

            case STATION_TYPE_PARTY:
                stationsAdapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
//                stationsAdapter = new StationsAdapter(DataService.getInstance().getPartyStations());
                break;

            case STATION_TYPE_RECENT:
                stationsAdapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
//                stationsAdapter = new StationsAdapter(DataService.getInstance().getRecentStations());
                break;
        }

        recyclerView.setAdapter(stationsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}
