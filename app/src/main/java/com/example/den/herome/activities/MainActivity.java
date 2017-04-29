package com.example.den.herome.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.den.herome.R;
import com.example.den.herome.fragments.BioFragment;
import com.example.den.herome.fragments.MainFragment;
import com.example.den.herome.fragments.PickPowerFragment;
import com.example.den.herome.model.ViewData;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<ViewData> views;

    public ArrayList<ViewData> getViews() {
        return views;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views = new ArrayList<>();
        changeFragment(0);
    }

    public void changeFragment(int number){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);
        FragmentTransaction ft;


        switch (number){
            case 0:
                fragment = new MainFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.addToBackStack(null);
                ft.commit();
                break;

            case 1:
                fragment = new PickPowerFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.addToBackStack(null);
                ft.commit();
                break;

            default:
                fragment = new BioFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.addToBackStack(null);
                ft.commit();
                break;
        }
    }

    public static void addView(int drawablwLeft,String name,int drawableRight){
        views.add(new ViewData(drawablwLeft,name,drawableRight));
    }
    public void clearList(){
        views.clear();
    }
}
