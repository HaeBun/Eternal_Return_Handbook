package com.haebun.erhb.information.subject;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import static com.haebun.erhb.main.ServerData.SUBJECT_IMAGE_DIRECTORY;

public class SubjectPresenter {
    private SubjectData data;
    private TextView name_kor;
    private ImageView profile;

    public SubjectPresenter(JSONObject subject) throws Exception {
        this.data = new SubjectData(subject);
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
