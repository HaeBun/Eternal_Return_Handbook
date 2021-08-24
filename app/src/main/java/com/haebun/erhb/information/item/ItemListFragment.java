package com.haebun.erhb.information.item;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemListFragment extends Fragment {
    int layout;

    public ItemListFragment(int layout) {
        this.layout = layout;
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(layout, container, false);
        return view;
    }
}