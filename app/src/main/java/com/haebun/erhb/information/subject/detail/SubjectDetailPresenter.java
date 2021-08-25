package com.haebun.erhb.information.subject.detail;

import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

public class SubjectDetailPresenter {
    private SubjectDetailData data;
    private TextView name_kor;
    private ImageView profile;

    public SubjectDetailPresenter(JSONObject subject) throws Exception {
        this.data = new SubjectDetailData(subject);
    }

    public void setNameTextView(TextView name) {
        this.name_kor = name;
    }

    public void setProfileImageView(ImageView image) {
        this.profile = image;
    }

    public void load() {
        name_kor.setText(data.getName_kor());

        String imageType = data.getName().toLowerCase()+"/small_"+ data.getName().toLowerCase()+".png";

//        Glide.with(fragment)
//                .load(SUBJECT_IMAGE_DIRECTORY+imageType)
//                .into(profile);
    }
}
