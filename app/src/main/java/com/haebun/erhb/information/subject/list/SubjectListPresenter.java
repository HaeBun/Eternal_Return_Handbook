package com.haebun.erhb.information.subject.list;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.haebun.erhb.R;
import com.haebun.erhb.information.subject.detail.SubjectDetailActivity;

public class SubjectListPresenter {
    View view;
    public SubjectListPresenter(View view) {
        this.view = view;
    }

    public void load() {
        LinearLayout subject_list = view.findViewById(R.id.subject_list);

        for(int i = 0; i < subject_list.getChildCount(); i++) {
            LinearLayout subject_array = (LinearLayout) subject_list.getChildAt(i);

            for(int j = 0; j < subject_array.getChildCount(); j++) {
                LinearLayout subject = (LinearLayout) subject_array.getChildAt(j);
                subject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String resourceName = v.getResources().getResourceName(v.getId());
                        Log.d("TAG-C", "getChild-C:" + resourceName.split("/")[1]);

                        Intent intent = new Intent(v.getContext(), SubjectDetailActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
            }
        }
    }
}
