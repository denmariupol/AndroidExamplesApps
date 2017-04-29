package com.example.den.herome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.den.herome.R;
import com.example.den.herome.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{

    Button turtleButton,lightningButton,flightButton,
            webButton,laserButton, strengthbutton,chooseButton;
    private int leftDrawing,rightDrawable;
    private String name;
    private View chosedView;
    public PickPowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_power,container,false);
        turtleButton = (Button)view.findViewById(R.id.turtlePowerButton);
        lightningButton = (Button)view.findViewById(R.id.lightningButton);
        flightButton = (Button)view.findViewById(R.id.flightButton);
        webButton = (Button)view.findViewById(R.id.webButton);
        laserButton = (Button)view.findViewById(R.id.laserButton);
        strengthbutton = (Button)view.findViewById(R.id.strengthButton);
        chooseButton = (Button)view.findViewById(R.id.chooseButton);

        turtleButton.setOnClickListener(this);
        lightningButton.setOnClickListener(this);
        flightButton.setOnClickListener(this);
        webButton.setOnClickListener(this);
        laserButton.setOnClickListener(this);
        strengthbutton.setOnClickListener(this);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(2);
                name = ((Button)chosedView).getText().toString();
                MainActivity.addView(leftDrawing,name,rightDrawable);

            }
        });
        setDefaultButton();

        return view;

    }

    @Override
    public void onClick(View v) {
        chosedView = v;
        setDefaultButton();
        rightDrawable = R.drawable.item_selected;
        leftDrawing = 0;
        switch (v.getId()){
            case R.id.turtlePowerButton:
                leftDrawing = R.drawable.turtle_power;
                break;
            case R.id.lightningButton:
                leftDrawing = R.drawable.lightning;
                break;
            case R.id.flightButton:
                leftDrawing = R.drawable.super_man_crest;
                break;
            case R.id.webButton:
                leftDrawing = R.drawable.spider_web;
                break;
            case R.id.laserButton:
                leftDrawing = R.drawable.laser_vision;
                break;
            case R.id.strengthButton:
                leftDrawing = R.drawable.super_strength;
                break;
        }

        ((Button)v).setCompoundDrawablesWithIntrinsicBounds(leftDrawing,0,rightDrawable,0);
    }

    private void setDefaultButton(){
        turtleButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        lightningButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        flightButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        webButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        laserButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        strengthbutton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
    }

}
