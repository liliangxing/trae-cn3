package com.lynx.tasm.image.model;

/* loaded from: classes7.dex */
public class ImageInfo {
    private final int mHeight;
    private final boolean mIsAnim;
    private final int mWidth;

    public ImageInfo(int i, int i2, boolean z) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsAnim = z;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean isAnim() {
        return this.mIsAnim;
    }
}
