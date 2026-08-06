package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRemoteStreamSwitch {
    public boolean afterEnable;
    public int afterVideoIndex;
    public boolean beforeEnable;
    public int beforeVideoIndex;
    public boolean isScreen;
    public int reason;
    public String uid;

    public InternalRemoteStreamSwitch() {
    }

    public InternalRemoteStreamSwitch(String uid, boolean isScreen, int before_video_index, int after_video_index, boolean before_enable, boolean after_enable, int reason) {
        this.uid = uid;
        this.isScreen = isScreen;
        this.beforeVideoIndex = before_video_index;
        this.afterVideoIndex = after_video_index;
        this.beforeEnable = before_enable;
        this.afterEnable = after_enable;
        this.reason = reason;
    }

    public static InternalRemoteStreamSwitch create(String uid, boolean isScreen, int before_video_index, int after_video_index, boolean before_enable, boolean after_enable, int reason) {
        return new InternalRemoteStreamSwitch(uid, isScreen, before_video_index, after_video_index, before_enable, after_enable, reason);
    }
}
