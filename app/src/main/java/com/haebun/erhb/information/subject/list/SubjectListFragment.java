package com.haebun.erhb.information.subject.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haebun.erhb.R;

public class SubjectListFragment extends Fragment {
    SubjectListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);
        presenter = new SubjectListPresenter(view);
        presenter.load();

        return view;
    }

}
