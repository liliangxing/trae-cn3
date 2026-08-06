package com.lynx.tasm.behavior.ui;

/* loaded from: classes7.dex */
public class MeaningfulPaintingArea {
    int mHeight;
    boolean mIsValid;
    int mOffsetX;
    int mOffsetY;
    int mWidth;
    int mVisibleStatus = 0;
    float mAlpha = 1.0f;
    float mScaleX = 1.0f;
    float mScaleY = 1.0f;

    /* loaded from: classes7.dex */
    public interface IMeaningfulPaintingAreaInvalidateHook {
        IDrawChildHook getDrawChildHook();

        void invalidateMeaningfulPaintingArea();
    }

    public MeaningfulPaintingArea(int i, int i2, int i3, int i4, boolean z) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mIsValid = z;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public int getVisibleStatus() {
        return this.mVisibleStatus;
    }

    public void setVisibleStatus(int i) {
        this.mVisibleStatus = i;
    }
}
