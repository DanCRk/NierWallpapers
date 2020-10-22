package com.wallpaper.nier.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wallpaper.nier.fragments.tab1Fragment;
import com.wallpaper.nier.fragments.tab2Fragment;
import com.wallpaper.nier.fragments.tab3Fragment;

public class PagerControler extends FragmentPagerAdapter {
    int numtabs;

    public PagerControler(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numtabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tab1Fragment();
            case 1:
                return new tab2Fragment();
            case 2:
                return new tab3Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numtabs;
    }
}
