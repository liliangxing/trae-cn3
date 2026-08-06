package com.bytedance.lynx.service.image.decoder;

/* loaded from: classes4.dex */
class MovieScaleHolder {
    private final int mMovieHeight;
    private final int mMovieWidth;
    private int mViewPortHeight;
    private int mViewPortWidth;
    private float mScale = 1.0f;
    private float mLeft = 0.0f;
    private float mTop = 0.0f;

    public MovieScaleHolder(int i, int i2) {
        this.mMovieWidth = i;
        this.mMovieHeight = i2;
    }

    public synchronized float getScale() {
        return this.mScale;
    }

    public synchronized float getLeft() {
        return this.mLeft;
    }

    public synchronized float getTop() {
        return this.mTop;
    }

    public synchronized void updateViewPort(int i, int i2) {
        if (this.mViewPortWidth == i && this.mViewPortHeight == i2) {
            return;
        }
        this.mViewPortWidth = i;
        this.mViewPortHeight = i2;
        determineScaleAndPosition();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:8:0x0025, B:9:0x0037, B:15:0x002d, B:16:0x0033, B:19:0x001b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void determineScaleAndPosition() {
        int i;
        int i2;
        int i3 = this.mMovieWidth;
        float f = i3 / this.mMovieHeight;
        int i4 = this.mViewPortWidth;
        int i5 = this.mViewPortHeight;
        float f2 = i4 / i5;
        if (f2 > f) {
            i = (int) (i5 * f);
        } else if (f2 < f) {
            i2 = (int) (i4 / f);
            i = i4;
            if (i4 <= i3) {
                this.mScale = i3 / i4;
            } else if (i3 > i4) {
                this.mScale = i4 / i3;
            } else {
                this.mScale = 1.0f;
            }
            float f3 = (i4 - i) / 2.0f;
            float f4 = this.mScale;
            this.mLeft = f3 / f4;
            this.mTop = ((i5 - i2) / 2.0f) / f4;
        } else {
            i = i4;
        }
        i2 = i5;
        if (i4 <= i3) {
        }
        float f32 = (i4 - i) / 2.0f;
        float f42 = this.mScale;
        this.mLeft = f32 / f42;
        this.mTop = ((i5 - i2) / 2.0f) / f42;
    }
}
