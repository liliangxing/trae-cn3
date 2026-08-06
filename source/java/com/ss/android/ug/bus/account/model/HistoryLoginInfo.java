package com.ss.android.ug.bus.account.model;

/* loaded from: classes7.dex */
public class HistoryLoginInfo {
    private String avatarUrl;
    private String screenName;
    private String secUid;
    private long uid;

    public HistoryLoginInfo(long j, String str, String str2, String str3) {
        this.uid = j;
        this.secUid = str;
        this.avatarUrl = str2;
        this.screenName = str3;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String getSecUid() {
        return this.secUid;
    }

    public void setSecUid(String str) {
        this.secUid = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }

    public String toString() {
        return "HistoryLoginInfo{uid=" + this.uid + ", secUid='" + this.secUid + "', avatarUrl='" + this.avatarUrl + "', screenName='" + this.screenName + "'}";
    }
}
