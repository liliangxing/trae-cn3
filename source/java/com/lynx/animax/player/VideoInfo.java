package com.lynx.animax.player;

import android.media.MediaFormat;

/* loaded from: classes6.dex */
public class VideoInfo {
    private MediaFormat mFormat;
    private int mFrameCount;
    private float mFrameRate;
    private int mHeight;
    private int mVideoTrackIndex = -1;
    private int mWidth;

    public MediaFormat getFormat() {
        return this.mFormat;
    }

    public void setFormat(MediaFormat mediaFormat) {
        this.mFormat = mediaFormat;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public void setFrameRate(float f) {
        this.mFrameRate = f;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public void setFrameCount(int i) {
        this.mFrameCount = i;
    }

    public int getVideoTrackIndex() {
        return this.mVideoTrackIndex;
    }

    public void setVideoTrackIndex(int i) {
        this.mVideoTrackIndex = i;
    }
}
