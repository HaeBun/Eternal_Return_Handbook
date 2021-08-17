package com.haebun.erhb.activity;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.haebun.erhb.R;
import com.haebun.erhb.service.promotion.PromotionPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends FragmentActivity {
    PromotionPresenter promotion = new PromotionPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView seasonDeadline = findViewById(R.id.season_deadline);
        ViewPager viewPager = findViewById(R.id.pager);
        seasonDeadline.setText(CalculateSeasonDeadline());

        promotion.setView(this);
        promotion.setFragmentManager(getSupportFragmentManager());
        promotion.setViewPager(viewPager);
        promotion.loadData();
    }

    private static String CalculateSeasonDeadline() {
        long time = System.currentTimeMillis();
        Date mDate = new Date(time);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");

        try {
            Date FirstDate = format.parse(format.format(mDate));
            Date SecondDate = format.parse("2021-10-28 11");

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