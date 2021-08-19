package com.haebun.erhb.main;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.haebun.erhb.R;
import com.haebun.erhb.service.promotion.PromotionPresenter;
import com.haebun.erhb.service.reward.RewardPresenter;
import com.haebun.erhb.service.season.SeasonPresenter;
import com.haebun.erhb.service.version.VersionPresenter;

public class MainActivity extends FragmentActivity {
    PromotionPresenter promotion = new PromotionPresenter();
    SeasonPresenter season = new SeasonPresenter();
    VersionPresenter version = new VersionPresenter();
    RewardPresenter reward = new RewardPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        ImageView banner = findViewById(R.id.banner);
        ImageView patchNoteBanner = findViewById(R.id.patchNoteBanner);
        ImageView reward_banner = findViewById(R.id.reward);
        TextView version = findViewById(R.id.version);
        TextView seasonEnds = findViewById(R.id.season_deadline);
        TextView rewardDeadline = findViewById(R.id.reward_deadline);

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
//        this.version.setPatchNoteImageView(patchNoteImage); // 패치 노트 요약 뷰 연결
        this.version.setPatchNoteBannerImageView(patchNoteBanner);

        reward.setContext(this);
        reward.setRewardImageView(reward_banner);
        reward.setDeadlineTextView(rewardDeadline);

        promotion.load();   // 프로모션 로드
        season.load();      // 시즌 데이터 로드
        this.version.load(); // 버전 데이터 로드
        reward.load();  // 보상 데이터 로드
    }
}