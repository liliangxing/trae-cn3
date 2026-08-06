package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface BitmapFrameCache {

    /* loaded from: classes6.dex */
    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache bitmapFrameCache, int i);

        void onFrameEvicted(BitmapFrameCache bitmapFrameCache, int i);
    }

    void clear(ImageFormat imageFormat, int i, boolean z);

    boolean contains(int i, ImageFormat imageFormat, boolean z);

    @Nullable
    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3, ImageFormat imageFormat, boolean z);

    @Nullable
    CloseableReference<Bitmap> getCachedFrame(int i, ImageFormat imageFormat, boolean z);

    @Nullable
    CloseableReference<Bitmap> getFallbackFrame(int i);

    int getSizeInBytes();

    void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z);

    void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z);

    void setFrameCacheListener(FrameCacheListener frameCacheListener);
}
