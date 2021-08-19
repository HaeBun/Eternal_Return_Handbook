package com.haebun.erhb.service.reward;

import org.json.JSONObject;

public class RewardData {
    private String reward;
    private String image;
    private String code;
    private String deadline;
    private String link;

    public RewardData(JSONObject item) throws Exception {
        this.reward = item.getString("보상");
        this.image = item.getString("이미지");
        this.code = item.getString("코드");
        this.deadline = item.getString("기간");
        this.link = item.getString("링크");
    }

    public String getImage() {
        return image;
    }

    public String getCode() {
        return code;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getReward() {
        return reward;
    }

    public String getLink() {
        return link;
    }
}
