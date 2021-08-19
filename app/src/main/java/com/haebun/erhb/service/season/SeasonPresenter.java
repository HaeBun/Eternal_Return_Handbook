package com.haebun.erhb.service.season;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.haebun.erhb.main.ServerData.REQUEST_SEASON_DATA;
import static com.haebun.erhb.main.ServerData.SEASON_BANNER_URL;

public class SeasonPresenter {
    ImageView banner;
    TextView seasonEnd;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setBannerImageView(ImageView banner) {
        this.banner = banner;
    }

    public void setSeasonEndsTextView(TextView seasonEnds) {
        this.seasonEnd = seasonEnds;
    }

    public void load() {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, REQUEST_SEASON_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("season");
                    SeasonData data = new SeasonData(array.getJSONObject(0));

                    loadSeason(data);
                } catch (Exception e) { e.printStackTrace(); }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { }
        });
        queue.add(request);
    }

    private void loadSeason(SeasonData data) {
        if(banner != null) {
            Glide.with(context)
                    .load(SEASON_BANNER_URL+ data.getImage())
                    .into(banner);

            banner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getVideo()));
                    context.startActivity(intent);
                }
            });
        }
        if(seasonEnd != null) seasonEnd.setText(calculateEndDays(data.getSeasonEnd()));
    }

    private static String calculateEndDays(String seasonEnds) {
        long time = System.currentTimeMillis();
        Date mDate = new Date(time);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date FirstDate = format.parse(format.format(mDate));
            Date SecondDate = format.parse(seasonEnds);
            // "2021-10-28 11"
            Log.d("DATECAL", FirstDate.toString());
            Log.d("DATECAL", SecondDate.toString());

            long calDate = FirstDate.getTime() - SecondDate.getTime();
            long calDateDays = calDate / (60*60000);

            calDateDays = Math.abs(calDateDays);

            long day = calDateDays / 24;
            long hour = calDateDays % 24;

            return String.valueOf(day)+"일 "+String.valueOf(hour) +"시";

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "일 시";
    }
}
