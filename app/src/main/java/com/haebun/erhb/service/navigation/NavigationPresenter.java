package com.haebun.erhb.service.navigation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.haebun.erhb.R;
import com.haebun.erhb.information.item.ItemListFragment;
import com.haebun.erhb.information.subject.list.SubjectListFragment;
import com.haebun.erhb.main.MainActivity;
import com.haebun.erhb.search.SearchFragment;

public class NavigationPresenter {
    Context context;
    TextView subject;
    TextView item;
    TextView map;
    TextView search;
    FrameLayout frameLayout;

    private Fragment subjectFragment, itemFragment, searchFragment;

    public void setFrameLayout(FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setSubjectButton(TextView subject) {
        this.subject = subject;
    }

    public void setItemButton(TextView item) {
        this.item = item;
    }

    public void setMapButton(TextView map) {
        this.map = map;
    }

    public void setSearchButton(TextView search) {
        this.search = search;
    }

    public void load() {
        TextView list[] = { subject, item, map, search };
        for(int i = 0; i < list.length; i++) {
            TextView button = list[i];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearSelect(list);
                    initializeSelect(button);
                    viewFragment(button);
                }
            });
        }
        viewFragment(subject);
    }

    private void viewFragment(TextView view) {
        MainActivity activity = (MainActivity) MainActivity.activity;

        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();

        if(view.equals(subject)) {
            subjectFragment = new SubjectListFragment();
            tran.replace(frameLayout.getId(), subjectFragment).commit();
        }
        else if(view.equals(item)) {
            itemFragment = new ItemListFragment(R.layout.fragment_item_info);
            tran.replace(frameLayout.getId(), itemFragment).commit();
        }
        else if(view.equals(search)) {
            searchFragment = new SearchFragment(R.layout.fragment_search_dak_gg);
            tran.replace(frameLayout.getId(), searchFragment).commit();
        }
    }

    private void initializeSelect(TextView button) {
        FrameLayout parent = (FrameLayout) button.getParent().getParent();
        parent.setBackgroundColor(Color.parseColor("#30d6842c"));
        View child = parent.getChildAt(1);
        child.setBackgroundColor(Color.parseColor("#d6842c"));
    }

    public void clearSelect(TextView list[]) {
        for(int i = 0; i < list.length; i++) {
            FrameLayout parent = (FrameLayout) list[i].getParent().getParent();
            parent.setBackgroundColor(Color.parseColor("#00000000"));
            View child = parent.getChildAt(1);
            child.setBackgroundColor(Color.parseColor("#3b3a36"));
        }
    }
}
