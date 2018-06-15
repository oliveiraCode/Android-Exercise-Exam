package com.lfoliveira.lasalle.exampleexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {


    //create the constructor
    public SwipeAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new LightFragment();
        } else {
            return new StorageFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
