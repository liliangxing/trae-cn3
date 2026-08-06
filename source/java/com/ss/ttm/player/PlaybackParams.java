package com.ss.ttm.player;

/* loaded from: classes7.dex */
public final class PlaybackParams {
    protected static final int DEFAULT_VALUE = -1;
    private int mDescribeContents = -1;
    private int mAudioFallbackMode = -1;
    private float mPitch = -1.0f;
    private float mSpeed = -1.0f;

    public PlaybackParams allowDefaults() {
        return this;
    }

    public int describeContents() {
        return this.mDescribeContents;
    }

    public int getAudioFallbackMode() {
        return this.mAudioFallbackMode;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public PlaybackParams setAudioFallbackMode(int audioFallbackMode) {
        this.mAudioFallbackMode = audioFallbackMode;
        return this;
    }

    public PlaybackParams setPitch(float pitch) {
        this.mPitch = pitch;
        return this;
    }

    public PlaybackParams setSpeed(float speed) {
        this.mSpeed = speed;
        return this;
    }
}
