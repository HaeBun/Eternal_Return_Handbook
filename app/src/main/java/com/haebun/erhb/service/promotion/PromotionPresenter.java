package com.haebun.erhb.service.promotion;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.haebun.erhb.activity.ServerData.REQUEST_PROMOTION_LIST;

public class PromotionPresenter {
    private Context context;
    PromotionAdapter adapter;
    ViewPager viewPager;
    FragmentManager fm;

    public void setView(Context context) {
        this.context = context;
    }

    public void setFragmentManager(FragmentManager fm) {
        this.fm = fm;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void loadData() {
        RequestQueue queue = Volley.newRequestQueue(context);
        adapter = new PromotionAdapter(fm);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REQUEST_PROMOTION_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    LoadPromotion(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            private void LoadPromotion(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("promotion");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);

                        PromotionData data = new PromotionData(item);

                        PromotionFragment fragment = new PromotionFragment(data);
                        adapter.addItem(fragment);
                    }

                    viewPager.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEYLOG", error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
