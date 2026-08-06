package com.facebook.imagepipeline.request;

import com.facebook.imagepipeline.image.ColorCalculator;

/* loaded from: classes6.dex */
public class CalculateColorConfig {
    private final int mCalculateHeight;
    private final ColorCalculator.PhotoBgColorStyle mPhotoBgColorStyle;
    private final int mResizeBitmapTo;

    public CalculateColorConfig(int i, int i2, ColorCalculator.PhotoBgColorStyle photoBgColorStyle) {
        this.mCalculateHeight = i;
        this.mResizeBitmapTo = i2;
        this.mPhotoBgColorStyle = photoBgColorStyle;
    }

    public int getCalculateHeight() {
        return this.mCalculateHeight;
    }

    public int getResizeBitmapTo() {
        return this.mResizeBitmapTo;
    }

    public ColorCalculator.PhotoBgColorStyle getPhotoBgColorStyle() {
        return this.mPhotoBgColorStyle;
    }
}
