package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationInformation;

/* loaded from: classes6.dex */
public class DropFramesFrameScheduler implements FrameScheduler {
    private static final int UNSET = -1;
    private final AnimationInformation mAnimationInformation;
    private long mLoopDurationMs = -1;

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public FrameScheduler forNewFrameScheduler(FrameScheduler frameScheduler) {
        return null;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public void setStartTime(long j) {
    }

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.mAnimationInformation = animationInformation;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        if (isInfiniteAnimation() || j / getLoopDurationMs() < this.mAnimationInformation.getLoopCount()) {
            return getFrameNumberWithinLoop(j % getLoopDurationMs());
        }
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long j = this.mLoopDurationMs;
        if (j != -1) {
            return j;
        }
        this.mLoopDurationMs = 0L;
        int frameCount = this.mAnimationInformation.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mLoopDurationMs += this.mAnimationInformation.getFrameDurationMs(i);
        }
        return this.mLoopDurationMs;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += this.mAnimationInformation.getFrameDurationMs(i);
        }
        return j;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        long loopDurationMs = getLoopDurationMs();
        long j2 = 0;
        if (loopDurationMs == 0) {
            return -1L;
        }
        if (!isInfiniteAnimation() && j / getLoopDurationMs() >= this.mAnimationInformation.getLoopCount()) {
            return -1L;
        }
        long j3 = j % loopDurationMs;
        int frameCount = this.mAnimationInformation.getFrameCount();
        for (int i = 0; i < frameCount && j2 <= j3; i++) {
            j2 += this.mAnimationInformation.getFrameDurationMs(i);
        }
        return j + (j2 - j3);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        return this.mAnimationInformation.getLoopCount() == 0;
    }

    int getFrameNumberWithinLoop(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mAnimationInformation.getFrameDurationMs(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
