package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class UserInfo {
    public String extraInfo;
    public String uid;

    public UserInfo(String uid, String extraInfo) {
        this.uid = uid;
        this.extraInfo = extraInfo;
    }

    public static UserInfo create(String uid, String extraInfo) {
        return new UserInfo(uid, extraInfo);
    }

    public String getUid() {
        return this.uid;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }
}
