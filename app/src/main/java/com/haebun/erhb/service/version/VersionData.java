package com.haebun.erhb.service.version;

import org.json.JSONObject;

public class VersionData {
    private String version;
    private String patchNote;
    private String patchNoteImage;
    private String patchNoteBanner;

    public VersionData(JSONObject item) throws Exception {
        this.version = item.getString("버전");
        this.patchNote = item.getString("패치노트");
        this.patchNoteImage = item.getString("패치노트_요약_이미지");
        this.patchNoteBanner = item.getString("패치노트_배너");
    }

    public String getVersion() {
        return version;
    }

    public String getPatchNote() {
        return patchNote;
    }

    public String getPatchNoteImage() {
        return patchNoteImage;
    }

    public String getPatchNoteBanner() {
        return patchNoteBanner;
    }

}
