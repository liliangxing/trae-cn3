package com.bytedance.lottie;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final boolean hasAlpha;
    private final int height;
    private final String id;
    private final int width;

    public LottieImageAsset(int i, int i2, String str, String str2, String str3, boolean z) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.dirName = str3;
        this.hasAlpha = z;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getDirName() {
        return this.dirName;
    }

    public boolean isHasAlpha() {
        return this.hasAlpha;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
