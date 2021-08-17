package com.haebun.erhb.service.promotion;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PromotionAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> items = new ArrayList<Fragment>();

    public PromotionAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addItem(PromotionFragment fragment) {
        items.add(fragment);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return getFragmentBasedOnPosition(position);
    }

    private Fragment getFragmentBasedOnPosition(int position) {
        return items.get(position);
    }

}

