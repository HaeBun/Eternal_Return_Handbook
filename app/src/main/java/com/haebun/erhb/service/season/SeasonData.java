package com.haebun.erhb.service.season;

import org.json.JSONObject;

public class SeasonData {
    private String season;
    private String image;
    private String seasonEnd;
    private String video;

    public SeasonData(JSONObject item) throws Exception {
        this.season = item.getString("시즌");
        this.image = item.getString("시즌_배너");
        this.seasonEnd = item.getString("종료기간");
        this.video = item.getString("시즌_소개_영상");
    };

    public String getVideo() { return video; }

    public String getSeason() {
        return season;
    }

    public String getImage() {
        return image;
    }

    public String getSeasonEnd() {
        return seasonEnd;
    }
}
