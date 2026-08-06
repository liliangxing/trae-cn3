package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KeepLastFrameCache implements BitmapFrameCache {
    private static final int FRAME_NUMBER_UNSET = -1;

    @Nullable
    private BitmapFrameCache.FrameCacheListener mFrameCacheListener;

    @Nullable
    private CloseableReference<Bitmap> mLastBitmapReference;
    private int mLastFrameNumber = -1;

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i, ImageFormat imageFormat, boolean z) {
        if (this.mLastFrameNumber != i) {
            return null;
        }
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3, ImageFormat imageFormat, boolean z) {
        try {
        } finally {
            closeAndResetLastBitmapReference();
        }
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i, ImageFormat imageFormat, boolean z) {
        boolean z2;
        if (i == this.mLastFrameNumber) {
            z2 = CloseableReference.isValid(this.mLastBitmapReference);
        }
        return z2;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mLastBitmapReference;
        return closeableReference == null ? 0 : BitmapUtil.getSizeInBytes(closeableReference.get());
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear(ImageFormat imageFormat, int i, boolean z) {
        closeAndResetLastBitmapReference();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z) {
        int i3;
        if (closeableReference != null) {
            if (this.mLastBitmapReference != null && closeableReference.get().equals(this.mLastBitmapReference.get())) {
                return;
            }
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.mFrameCacheListener;
        if (frameCacheListener != null && (i3 = this.mLastFrameNumber) != -1) {
            frameCacheListener.onFrameEvicted(this, i3);
        }
        this.mLastBitmapReference = CloseableReference.cloneOrNull(closeableReference);
        BitmapFrameCache.FrameCacheListener frameCacheListener2 = this.mFrameCacheListener;
        if (frameCacheListener2 != null) {
            frameCacheListener2.onFrameCached(this, i);
        }
        this.mLastFrameNumber = i;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.mFrameCacheListener = frameCacheListener;
    }

    private synchronized void closeAndResetLastBitmapReference() {
        int i;
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.mFrameCacheListener;
        if (frameCacheListener != null && (i = this.mLastFrameNumber) != -1) {
            frameCacheListener.onFrameEvicted(this, i);
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        this.mLastBitmapReference = null;
        this.mLastFrameNumber = -1;
    }
}
