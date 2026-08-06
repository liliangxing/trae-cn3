package com.facebook.imagepipeline.blurhash;

/* loaded from: classes6.dex */
public final class BlurHashConfig {
    private static final int MAX_BLUR_HASH_HEIGHT = 100;
    private static final int MAX_BLUR_HASH_WIDTH = 100;
    final int mHeight;
    final float mPunch;
    final boolean mUseCache;
    final int mWidth;
    final int targetHeight;
    final int targetWidth;

    public BlurHashConfig(int i, int i2) {
        this(i, i2, 1.0f, true);
    }

    public BlurHashConfig(int i, int i2, float f, boolean z) {
        this(i, i2, f, z, 0, 0);
    }

    public BlurHashConfig(int i, int i2, float f, boolean z, int i3, int i4) {
        this.mWidth = Math.min(i, 100);
        this.mHeight = Math.min(i2, 100);
        this.mPunch = f;
        this.mUseCache = z;
        this.targetWidth = i3;
        this.targetHeight = i4;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public float getPunch() {
        return this.mPunch;
    }

    public boolean isUseCache() {
        return this.mUseCache;
    }
}
