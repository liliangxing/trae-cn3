package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class NoOpCache implements BitmapFrameCache {
    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void clear(ImageFormat imageFormat, int i, boolean z) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean contains(int i, ImageFormat imageFormat, boolean z) {
        return false;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3, ImageFormat imageFormat, boolean z) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getCachedFrame(int i, ImageFormat imageFormat, boolean z) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getFallbackFrame(int i) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2, ImageFormat imageFormat, boolean z) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }
}
