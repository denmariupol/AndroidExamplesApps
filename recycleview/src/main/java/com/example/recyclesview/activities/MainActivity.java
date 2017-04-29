package com.example.recyclesview.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.recyclesview.R;
import com.example.recyclesview.fragments.DetailsFragment;
import com.example.recyclesview.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);
        changeFragment(0);
    }

    public void changeFragment(int number){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment;
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
                fragment = new DetailsFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.addToBackStack(null);
                ft.commit();
                break;
        }
    }

    public void loadDetailScreen(){
        changeFragment(1);
    }
}
