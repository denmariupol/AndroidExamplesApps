package com.example.recyclesview.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclesview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        Fragment topFragment,middleFragment,bottomFragment;

        FragmentManager fm = getActivity().getSupportFragmentManager();
        topFragment = new StationsFragment().newInstance(StationsFragment.STATION_TYPE_FEATURED);
        fm.beginTransaction().replace(R.id.container_top_row,topFragment).addToBackStack(null).commit();

        middleFragment = new StationsFragment().newInstance(StationsFragment.STATION_TYPE_RECENT);
        fm.beginTransaction().replace(R.id.container_middle_row,middleFragment).addToBackStack(null).commit();

        bottomFragment = new StationsFragment().newInstance(StationsFragment.STATION_TYPE_PARTY);
        fm.beginTransaction().replace(R.id.container_bottom_row,bottomFragment).addToBackStack(null).commit();

        return view;
    }

}
