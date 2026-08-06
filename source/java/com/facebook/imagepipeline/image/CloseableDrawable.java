package com.facebook.imagepipeline.image;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class CloseableDrawable extends CloseableImage {
    private Drawable mDrawable;

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getImageCount() {
        return 1;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        return 0;
    }

    public CloseableDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public Drawable getUnderlyingDrawable() {
        return this.mDrawable;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDrawable = null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isClosed() {
        return this.mDrawable == null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return 0;
        }
        return Math.max(0, drawable.getIntrinsicWidth());
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return 0;
        }
        return Math.max(0, drawable.getIntrinsicHeight());
    }
}
