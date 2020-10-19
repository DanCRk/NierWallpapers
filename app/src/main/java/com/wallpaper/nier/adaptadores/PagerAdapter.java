package com.wallpaper.nier.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wallpaper.nier.tab1Fragment;
import com.wallpaper.nier.tab2Fragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tab1Fragment();
            case 1:
                return new tab2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return numoftabs; }
}
