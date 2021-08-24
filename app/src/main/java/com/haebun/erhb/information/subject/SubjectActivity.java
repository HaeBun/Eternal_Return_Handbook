package com.haebun.erhb.information.subject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haebun.erhb.R;

import org.json.JSONObject;

public class SubjectActivity extends Fragment {
    private SubjectPresenter presenter;


    public SubjectActivity(JSONObject subject) throws Exception {
        this.presenter = new SubjectPresenter(subject);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = (ViewGroup) inflater.inflate(R.layout.item_subject, container, false);
//
//        TextView name = rootView.findViewById(R.id.subject_name);
//        ImageView image = rootView.findViewById(R.id.subject_image);
//
//        presenter.setNameTextView(name);
//        presenter.setProfileImageView(image);
//        presenter.load();
//
//        return rootView;
        return null;
    }


}
