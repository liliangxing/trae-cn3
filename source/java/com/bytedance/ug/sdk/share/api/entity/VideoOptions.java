package com.bytedance.ug.sdk.share.api.entity;

/* loaded from: classes4.dex */
public class VideoOptions {
    private int height;
    private int width;
    private int startTimeMs = 0;
    private int endTimeMs = 0;

    public int getStartTimeMs() {
        return this.startTimeMs;
    }

    public void setStartTimeMs(int i) {
        this.startTimeMs = i;
    }

    public int getEndTimeMs() {
        return this.endTimeMs;
    }

    public void setEndTimeMs(int i) {
        this.endTimeMs = i;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
