package com.example.imageapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.imageapp.fragments.FeedActivityFragment;
import com.example.imageapp.fragments.HomeFragment;
import com.example.imageapp.fragments.ProfileFragment;
import com.example.imageapp.fragments.SearchFragment;

/**
 * Created by den on 2017-04-29.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return SearchFragment.newInstance();
            case 2:
                return FeedActivityFragment.newInstance();
            default:
                return ProfileFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "HOME";
            case 1:
                return "SEARCH";
            case 2:
                return "ACTIVITY";
            case 3:
                return "PROFILE";
        }
        return null;
    }
}
