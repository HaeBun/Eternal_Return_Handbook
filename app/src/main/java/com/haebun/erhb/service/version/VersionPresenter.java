package com.haebun.erhb.service.version;

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
import com.haebun.erhb.service.season.SeasonData;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.haebun.erhb.main.ServerData.REQUEST_SEASON_DATA;
import static com.haebun.erhb.main.ServerData.REQUEST_VERSION_DATA;
import static com.haebun.erhb.main.ServerData.SEASON_BANNER_URL;

public class VersionPresenter {
    TextView version;
    ImageView patchNoteImageView;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setVersionTextView(TextView version) {
        this.version = version;
    }

    public void setPatchNoteImageView(ImageView patchNoteImageView) {
        this.patchNoteImageView = patchNoteImageView;
    }

    public void load() {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, REQUEST_VERSION_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("version");
                    VersionData data = new VersionData(array.getJSONObject(0));

                    loadVersion(data);
                } catch (Exception e) { e.printStackTrace(); }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { }
        });
        queue.add(request);
    }

    private void loadVersion(VersionData data) {
        if(patchNoteImageView != null) {
            Glide.with(context)
                    .load(data.getPatchNoteImage())
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(patchNoteImageView);

            patchNoteImageView.setScaleType(ImageView.ScaleType.CENTER);

            patchNoteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getPatchNote()));
                    context.startActivity(intent);
                }
            });
        }
        if(version != null) version.setText(data.getVersion());
    }
}
