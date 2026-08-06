package com.facebook.common.heif;

/* loaded from: classes6.dex */
public class HeifDecodeData {
    private boolean mHasAlpha;
    private int mHdrType;
    private int mHeifDecError;
    private int mHeight;
    private int mWidth;

    public int getHeifDecError() {
        return this.mHeifDecError;
    }

    public void setHeifDecError(int i) {
        this.mHeifDecError = i;
    }

    public boolean hasAlpha() {
        return this.mHasAlpha;
    }

    public void setHasAlpha(boolean z) {
        this.mHasAlpha = z;
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

    public int getHdrType() {
        return this.mHdrType;
    }

    public void setHdrType(int i) {
        this.mHdrType = i;
    }
}
