package com.facebook.imagepipeline.blurhash2;

/* loaded from: classes6.dex */
public final class PreviewHashConfig {
    public static final int DEFAULT_BLUR_RADIUS = 1;
    public static final int DEFAULT_HEIGHT = 0;
    public static final int DEFAULT_ITERATIONS = 1;
    public static final int DEFAULT_WIDTH = 0;
    public static final int JPEG_PREVIEW = 0;
    public static final int VVIC_PREVIEW = 1;
    final int mBlurRadius;
    final int mHeight;
    final boolean mIsOptVvic;
    final int mIterations;
    final int mWidth;

    public PreviewHashConfig(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public PreviewHashConfig(boolean z, int i, int i2) {
        this(z, i, i2, 0, 0);
    }

    public PreviewHashConfig(int i, int i2, int i3) {
        this(i == 1, i2, i3, 0, 0);
    }

    public PreviewHashConfig(int i, int i2, int i3, int i4) {
        this(false, i, i2, i3, i4);
    }

    public PreviewHashConfig(boolean z, int i, int i2, int i3, int i4) {
        this.mIsOptVvic = z;
        this.mIterations = i;
        this.mBlurRadius = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    public PreviewHashConfig(int i, int i2, int i3, int i4, int i5) {
        this.mIsOptVvic = i == 1;
        this.mIterations = i2;
        this.mBlurRadius = i3;
        this.mWidth = i4;
        this.mHeight = i5;
    }

    public boolean isOptVvic() {
        return this.mIsOptVvic;
    }

    public int getIterations() {
        return this.mIterations;
    }

    public int getBlurRadius() {
        return this.mBlurRadius;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
