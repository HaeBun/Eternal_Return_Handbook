package com.haebun.erhb.service.promotion;

import org.json.JSONObject;

public class PromotionData {
    private String title;
    private String description;
    private String image;
    private String link;

    public PromotionData(JSONObject item) throws Exception {
        this.title = item.getString("제목");
        this.description = item.getString("내용");
        this.image = item.getString("이미지_링크");
        this.link = item.getString("접근_링크");
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

}
