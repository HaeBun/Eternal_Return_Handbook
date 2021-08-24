package com.haebun.erhb.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.haebun.erhb.R;
import com.haebun.erhb.service.navigation.NavigationPresenter;
import com.haebun.erhb.service.promotion.PromotionPresenter;
import com.haebun.erhb.service.reward.RewardPresenter;
import com.haebun.erhb.service.season.SeasonPresenter;
import com.haebun.erhb.service.version.VersionPresenter;

public class MainActivity extends AppCompatActivity {
    PromotionPresenter promotion = new PromotionPresenter();
    SeasonPresenter season = new SeasonPresenter();
    VersionPresenter version = new VersionPresenter();
    RewardPresenter reward = new RewardPresenter();
    NavigationPresenter navigation = new NavigationPresenter();

    public static MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        ViewPager viewPager = findViewById(R.id.pager);
        ImageView banner = findViewById(R.id.banner);
        ImageView patchNoteBanner = findViewById(R.id.patchNoteBanner);
        ImageView reward_banner = findViewById(R.id.reward);
        TextView version = findViewById(R.id.version);
        TextView seasonEnds = findViewById(R.id.season_deadline);
        TextView rewardDeadline = findViewById(R.id.reward_deadline);
        TextView subject = findViewById(R.id.subject);
        TextView item = findViewById(R.id.item);
        TextView map = findViewById(R.id.map);
        TextView search = findViewById(R.id.search);
        FrameLayout information = findViewById(R.id.information);

        // 프로모션 presenter 연결
        promotion.setContext(this);
        promotion.setFragmentManager(getSupportFragmentManager());
        promotion.setViewPager(viewPager);        // 화면에 보여질 뷰 페이저 연결

        // 시즌 배너 presenter 연결
        season.setContext(this);
        season.setBannerImageView(banner);          // 배너 이미지 뷰 연결
        season.setSeasonEndsTextView(seasonEnds);   // 시즌 종료 기간 연결

        // 버전 presenter 연결
        this.version.setContext(this);
        this.version.setVersionTextView(version);  // 버전 뷰 연결
        this.version.setPatchNoteBannerImageView(patchNoteBanner);

        // 보상 presenter 연결
        reward.setContext(this);
        reward.setRewardImageView(reward_banner);
        reward.setDeadlineTextView(rewardDeadline);

        // 네비게이션 presenter 연결
        navigation.setContext(this);
        navigation.setSubjectButton(subject);
        navigation.setItemButton(item);
        navigation.setMapButton(map);
        navigation.setSearchButton(search);
        navigation.setFrameLayout(information);

        promotion.load();   // 프로모션 로드
        season.load();      // 시즌 데이터 로드
        this.version.load(); // 버전 데이터 로드
        reward.load();  // 보상 데이터 로드
        navigation.load(); // 네비게이션 로드
    }
}