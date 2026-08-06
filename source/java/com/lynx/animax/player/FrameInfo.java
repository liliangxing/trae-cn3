package com.lynx.animax.player;

/* loaded from: classes6.dex */
public class FrameInfo {
    private int mBeg;
    private int mEnd;
    private long mPresentationTimeUs;

    public FrameInfo(int i, int i2, long j) {
        this.mBeg = i;
        this.mEnd = i2;
        this.mPresentationTimeUs = j;
    }

    public int begin() {
        return this.mBeg;
    }

    public int end() {
        return this.mEnd;
    }

    public long getPresentationTimeUs() {
        return this.mPresentationTimeUs;
    }
}
