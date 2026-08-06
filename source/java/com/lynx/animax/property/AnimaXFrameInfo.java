package com.lynx.animax.property;

/* loaded from: classes6.dex */
public class AnimaXFrameInfo {
    private final float mEndFrame;
    private final AnimaXValueParam mEndValue;
    private final float mInterpolatedProgress;
    private final float mLinearProgress;
    private final float mOverallProgress;
    private final float mStartFrame;
    private final AnimaXValueParam mStartValue;

    public AnimaXFrameInfo(float f, float f2, AnimaXValueParam animaXValueParam, AnimaXValueParam animaXValueParam2, float f3, float f4, float f5) {
        this.mStartFrame = f;
        this.mEndFrame = f2;
        this.mStartValue = animaXValueParam;
        this.mEndValue = animaXValueParam2;
        this.mLinearProgress = f3;
        this.mInterpolatedProgress = f4;
        this.mOverallProgress = f5;
    }

    public float getStartFrame() {
        return this.mStartFrame;
    }

    public float getEndFrame() {
        return this.mEndFrame;
    }

    public AnimaXValueParam getStartValue() {
        return this.mStartValue;
    }

    public AnimaXValueParam getEndValue() {
        return this.mEndValue;
    }

    public float getLinearProgress() {
        return this.mLinearProgress;
    }

    public float getInterpolatedProgress() {
        return this.mInterpolatedProgress;
    }

    public float getOverallProgress() {
        return this.mOverallProgress;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("AnimaXFrameInfo{frames=").append(this.mStartFrame).append("->").append(this.mEndFrame).append(", startValue=");
        Object obj = this.mStartValue;
        if (obj == null) {
            obj = "null";
        }
        StringBuilder append2 = append.append(obj).append(", endValue=");
        AnimaXValueParam animaXValueParam = this.mEndValue;
        return append2.append(animaXValueParam != null ? animaXValueParam : "null").append(", progress=[linear=").append(String.format("%.2f", Float.valueOf(this.mLinearProgress))).append(", interpolated=").append(String.format("%.2f", Float.valueOf(this.mInterpolatedProgress))).append(", overall=").append(String.format("%.2f", Float.valueOf(this.mOverallProgress))).append("]}").toString();
    }
}
