package com.example.imageapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imageapp.R;


public class FeedActivityFragment extends Fragment {


    public FeedActivityFragment() {
        // Required empty public constructor
    }


    public static FeedActivityFragment newInstance() {
        FeedActivityFragment fragment = new FeedActivityFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_activity, container, false);
    }

}
