package com.haebun.erhb.service.promotion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.haebun.erhb.R;
import com.haebun.erhb.activity.ServerData;

public class PromotionFragment extends Fragment {

    PromotionData data;

    public PromotionFragment(PromotionData data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_promotion, container, false);

        ImageView image = rootView.findViewById(R.id.promotion_image);
        TextView title = rootView.findViewById(R.id.promotion_title);
        TextView description = rootView.findViewById(R.id.promotion_description);

        Glide.with(getContext())
                .load(ServerData.PROMOTION_IMAGE_URL+data.getImage())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(image);

        image.setAdjustViewBounds(true);

        title.setText(data.getTitle());
        description.setText(data.getDescription());

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getLink()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}