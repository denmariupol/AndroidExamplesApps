package com.example.den.herome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.den.herome.R;
import com.example.den.herome.activities.MainActivity;
import com.example.den.herome.model.ViewData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    ArrayList<ViewData> views;
    public BioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        views = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bio,container,false);
        views = ((MainActivity)getActivity()).getViews();
        Button first = (Button)v.findViewById(R.id.firstAbilityh);
        Button second = (Button)v.findViewById(R.id.secondAbility);
        Button select = (Button)v.findViewById(R.id.chooseButton);
        first.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        second.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);

        first.setCompoundDrawablesWithIntrinsicBounds(views.get(0).getDrawableLeft(),0,views.get(0).getDrawableRight(),0);
        first.setText(views.get(0).getName());
        second.setCompoundDrawablesWithIntrinsicBounds(views.get(1).getDrawableLeft(),0,views.get(1).getDrawableRight(),0);
        second.setText(views.get(1).getName());

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(0);
                ((MainActivity)getActivity()).clearList();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

}
