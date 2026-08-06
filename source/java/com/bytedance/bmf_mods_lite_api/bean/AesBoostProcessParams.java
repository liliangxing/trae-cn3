package com.bytedance.bmf_mods_lite_api.bean;

/* loaded from: classes3.dex */
public class AesBoostProcessParams {
    public int groupIndex;
    public int interval;
    public boolean newVideo;
    public float simpleK;

    public AesBoostProcessParams() {
        this.simpleK = 1.0f;
    }

    public AesBoostProcessParams(boolean newVideo, int interval, int groupIndex) {
        this.simpleK = 1.0f;
        this.newVideo = newVideo;
        this.interval = interval;
        this.groupIndex = groupIndex;
    }

    public AesBoostProcessParams(boolean newVideo, int interval, int groupIndex, float simpleK) {
        this.newVideo = newVideo;
        this.interval = interval;
        this.groupIndex = groupIndex;
        this.simpleK = simpleK;
    }
}
