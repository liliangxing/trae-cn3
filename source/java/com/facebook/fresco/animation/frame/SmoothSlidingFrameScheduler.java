package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationBackend;

/* loaded from: classes6.dex */
public class SmoothSlidingFrameScheduler implements FrameScheduler {
    private static final String TAG = "FrameScheduler";
    private static final int UNSET = -1;
    private final AnimationBackend mAnimationBackend;
    private int mDecodeStatus;
    private int mFrameNumber;
    private long mLastDrawTimeMs;
    private int mLoopCount;
    private long mLoopDurationMs;
    private long mNowAnimationTimeMs;

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public void setStartTime(long j) {
    }

    public SmoothSlidingFrameScheduler(AnimationBackend animationBackend) {
        this(animationBackend, 0);
    }

    public SmoothSlidingFrameScheduler(AnimationBackend animationBackend, int i) {
        this.mLoopDurationMs = -1L;
        this.mLoopCount = 0;
        this.mFrameNumber = -1;
        this.mNowAnimationTimeMs = -1L;
        this.mLastDrawTimeMs = -1L;
        this.mAnimationBackend = animationBackend;
        this.mDecodeStatus = i;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        long loopDurationMs = getLoopDurationMs();
        if (loopDurationMs == 0) {
            return -1;
        }
        if (!isInfiniteAnimation() && j / loopDurationMs >= this.mAnimationBackend.getLoopCount()) {
            return -1;
        }
        int frameNumberWithinLoop = getFrameNumberWithinLoop(j % loopDurationMs);
        int i = 0;
        if (this.mFrameNumber == -1 || j2 != this.mLastDrawTimeMs) {
            this.mNowAnimationTimeMs = j;
            this.mLastDrawTimeMs = j;
            this.mFrameNumber = frameNumberWithinLoop;
            this.mLoopCount = 0;
            return frameNumberWithinLoop;
        }
        this.mLastDrawTimeMs = j;
        if (this.mNowAnimationTimeMs + this.mAnimationBackend.getFrameDurationMs(r1) > j) {
            return this.mFrameNumber;
        }
        this.mNowAnimationTimeMs = j;
        int i2 = this.mFrameNumber + 1;
        if (i2 >= this.mAnimationBackend.getFrameCount()) {
            int i3 = this.mDecodeStatus;
            if (i3 == 0 || i3 == 3) {
                this.mLoopCount++;
            } else {
                i = i2 - 1;
            }
        } else {
            i = i2;
        }
        if (this.mAnimationBackend.hasCacheFrame(i)) {
            this.mFrameNumber = i;
            return i;
        }
        return this.mFrameNumber;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long j = this.mLoopDurationMs;
        if (j != -1) {
            return j;
        }
        this.mLoopDurationMs = 0L;
        int frameCount = this.mAnimationBackend.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mLoopDurationMs += this.mAnimationBackend.getFrameDurationMs(i);
        }
        return this.mLoopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += this.mAnimationBackend.getFrameDurationMs(i);
        }
        return j;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        if (getLoopDurationMs() == 0) {
            return -1L;
        }
        if (!isInfiniteAnimation() && this.mLoopCount >= this.mAnimationBackend.getLoopCount()) {
            return -1L;
        }
        long frameDurationMs = this.mAnimationBackend.getFrameDurationMs(this.mFrameNumber);
        long j2 = this.mNowAnimationTimeMs + frameDurationMs;
        return j2 >= j ? j2 : j + frameDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        return this.mAnimationBackend.getLoopCount() == 0;
    }

    int getFrameNumberWithinLoop(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mAnimationBackend.getFrameDurationMs(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public FrameScheduler forNewFrameScheduler(FrameScheduler frameScheduler) {
        if (!(frameScheduler instanceof SmoothSlidingFrameScheduler)) {
            return null;
        }
        SmoothSlidingFrameScheduler smoothSlidingFrameScheduler = (SmoothSlidingFrameScheduler) frameScheduler;
        SmoothSlidingFrameScheduler smoothSlidingFrameScheduler2 = new SmoothSlidingFrameScheduler(smoothSlidingFrameScheduler.mAnimationBackend, smoothSlidingFrameScheduler.mDecodeStatus);
        smoothSlidingFrameScheduler2.mFrameNumber = this.mFrameNumber;
        smoothSlidingFrameScheduler2.mLastDrawTimeMs = this.mLastDrawTimeMs;
        smoothSlidingFrameScheduler2.mLoopCount = this.mLoopCount;
        smoothSlidingFrameScheduler2.mNowAnimationTimeMs = this.mNowAnimationTimeMs;
        return smoothSlidingFrameScheduler2;
    }
}
