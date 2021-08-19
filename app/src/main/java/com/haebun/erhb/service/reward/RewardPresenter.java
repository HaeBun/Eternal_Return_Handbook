package com.haebun.erhb.service.reward;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.haebun.erhb.common.Calculate;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.haebun.erhb.main.ServerData.REQUEST_REWARD_DATA;
import static com.haebun.erhb.main.ServerData.REWARD_BANNER_URL;

public class RewardPresenter {
    Context context;
    ImageView image;
    TextView deadline;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setRewardImageView(ImageView image) {
        this.image = image;
    }

    public void setDeadlineTextView(TextView deadline) {
        this.deadline = deadline;
    }

    public void load() {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, REQUEST_REWARD_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("reward");
                    RewardData data = new RewardData(array.getJSONObject(0));

                    loadReward(data);
                } catch (Exception e) { e.printStackTrace(); }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { }
        });
        queue.add(request);
    }

    private void loadReward(RewardData data) {
        if(image != null) {
            Glide.with(context)
                    .load(REWARD_BANNER_URL +data.getImage())
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(image);
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getLink()));
                context.startActivity(intent);
            }
        });

        if(deadline != null) {
            deadline.setText(Calculate.deadline(data.getDeadline())+"간 남음");
        }
    }
}
