package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationBackend;

/* loaded from: classes6.dex */
public class FixedSlidingHeifFrameScheduler implements FrameScheduler {
    private static final String TAG = "FixedFrameScheduler";
    private static final int UNSET = -1;
    private boolean isAnimatedStop;
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

    public FixedSlidingHeifFrameScheduler(AnimationBackend animationBackend) {
        this(animationBackend, 0);
    }

    public FixedSlidingHeifFrameScheduler(AnimationBackend animationBackend, int i) {
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
        if (getLoopDurationMs() == 0) {
            return -1;
        }
        if (!isInfiniteAnimation() && this.mLoopCount >= this.mAnimationBackend.getLoopCount()) {
            return -1;
        }
        int i = this.mFrameNumber;
        int i2 = 0;
        if (i == -1 || j2 != this.mLastDrawTimeMs) {
            this.mNowAnimationTimeMs = j;
            this.mLastDrawTimeMs = j;
            if (i == -1 || this.isAnimatedStop) {
                this.mFrameNumber = 0;
                this.isAnimatedStop = false;
            }
            this.mLoopCount = 0;
            return this.mFrameNumber;
        }
        this.mLastDrawTimeMs = j;
        if (this.mNowAnimationTimeMs + this.mAnimationBackend.getFrameDurationMs(i) > j) {
            return this.mFrameNumber;
        }
        this.mNowAnimationTimeMs = j;
        int i3 = this.mFrameNumber + 1;
        if (i3 >= this.mAnimationBackend.getFrameCount()) {
            int i4 = this.mDecodeStatus;
            if (i4 == 0 || i4 == 3) {
                this.mLoopCount++;
            } else {
                i2 = i3 - 1;
            }
        } else {
            i2 = i3;
        }
        this.mFrameNumber = i2;
        return i2;
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
        if (!(frameScheduler instanceof FixedSlidingHeifFrameScheduler)) {
            return null;
        }
        FixedSlidingHeifFrameScheduler fixedSlidingHeifFrameScheduler = (FixedSlidingHeifFrameScheduler) frameScheduler;
        FixedSlidingHeifFrameScheduler fixedSlidingHeifFrameScheduler2 = new FixedSlidingHeifFrameScheduler(fixedSlidingHeifFrameScheduler.mAnimationBackend, fixedSlidingHeifFrameScheduler.mDecodeStatus);
        fixedSlidingHeifFrameScheduler2.mFrameNumber = this.mFrameNumber;
        fixedSlidingHeifFrameScheduler2.mLastDrawTimeMs = this.mLastDrawTimeMs;
        fixedSlidingHeifFrameScheduler2.mLoopCount = this.mLoopCount;
        fixedSlidingHeifFrameScheduler2.mNowAnimationTimeMs = this.mNowAnimationTimeMs;
        return fixedSlidingHeifFrameScheduler2;
    }

    public void setAnimatedStop(boolean z) {
        this.isAnimatedStop = z;
    }
}
