package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedHeifFrameCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoFrameCache implements BitmapFrameCache {
    private static final Class<?> TAG = FrescoFrameCache.class;
    private final AnimatedFrameCache mAnimatedFrameCache;
    private final AnimatedHeifFrameCache mAnimatedHeifFrameCache;
    private final boolean mEnableBitmapReusing;
    private int mLastRenderedIndex;

    @Nullable
    private CloseableReference<CloseableImage> mLastRenderedItem;
    private final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames;

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.mLastRenderedIndex = -1;
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mAnimatedHeifFrameCache = new AnimatedHeifFrameCache(new SimpleCacheKey("Sample"), new HashMapMemoryCache());
        this.mEnableBitmapReusing = z;
        this.mPreparedPendingFrames = new SparseArray<>();
    }

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, AnimatedHeifFrameCache animatedHeifFrameCache, boolean z) {
        this.mLastRenderedIndex = -1;
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mAnimatedHeifFrameCache = animatedHeifFrameCache;
        this.mEnableBitmapReusing = z;
        this.mPreparedPendingFrames = new SparseArray<>();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i, ImageFormat imageFormat, boolean z) {
        if (DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z) {
            return this.mAnimatedHeifFrameCache.get(i);
        }
        if (this.mAnimatedFrameCache.contains(i)) {
            return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i));
        }
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mPreparedPendingFrames.get(i)));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3, ImageFormat imageFormat, boolean z) {
        if (DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z) {
            return null;
        }
        if (!this.mEnableBitmapReusing) {
            return null;
        }
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        if (r0.mAnimatedFrameCache.contains(r1) == false) goto L11;
     */
    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean contains(int i, ImageFormat imageFormat, boolean z) {
        boolean z2;
        if (DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z) {
            z2 = this.mAnimatedHeifFrameCache.contains(i);
            if (this.mPreparedPendingFrames.get(i) == null) {
            }
        }
        return z2;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        return getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear(ImageFormat imageFormat, int i, boolean z) {
        boolean z2 = DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z;
        CloseableReference.closeSafely(this.mLastRenderedItem);
        if (z2) {
            this.mAnimatedHeifFrameCache.clear();
        } else if (!FrescoCacheMonitorUtil.isOptAnimCacheClear() || this.mLastRenderedIndex == -1) {
            this.mAnimatedFrameCache.clear(this.mLastRenderedIndex);
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                this.mAnimatedFrameCache.clear(i2);
            }
        }
        this.mLastRenderedItem = null;
        this.mLastRenderedIndex = -1;
        if (!FrescoCacheMonitorUtil.isOptAnimCacheClear()) {
            for (int i3 = 0; i3 < this.mPreparedPendingFrames.size(); i3++) {
                CloseableReference<CloseableImage> valueAt = this.mPreparedPendingFrames.valueAt(i3);
                if (valueAt != null) {
                    CloseableReference.closeSafely(valueAt);
                    if (!z2) {
                        this.mAnimatedFrameCache.clear(this.mPreparedPendingFrames.keyAt(i3));
                    }
                }
            }
        }
        this.mPreparedPendingFrames.clear();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z) {
        Preconditions.checkNotNull(closeableReference);
        removePreparedReference(i);
        CloseableReference<CloseableImage> closeableReference2 = null;
        try {
            CloseableReference.closeSafely(this.mLastRenderedItem);
            if (imageFormat != null && DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z) {
                this.mLastRenderedItem = createImageReference(this.mAnimatedHeifFrameCache.cache(i, closeableReference));
            } else {
                closeableReference2 = createImageReference(closeableReference);
                if (closeableReference2 != null) {
                    this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i, closeableReference2);
                }
            }
            this.mLastRenderedIndex = i;
        } finally {
            CloseableReference.closeSafely(closeableReference2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:26:0x0007, B:29:0x000f, B:13:0x002b, B:15:0x0031, B:16:0x004c, B:24:0x003d, B:6:0x001a, B:12:0x0025), top: B:25:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:26:0x0007, B:29:0x000f, B:13:0x002b, B:15:0x0031, B:16:0x004c, B:24:0x003d, B:6:0x001a, B:12:0x0025), top: B:25:0x0007, outer: #1 }] */
    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2, @Nullable ImageFormat imageFormat, boolean z) {
        CloseableReference<CloseableImage> createImageReference;
        Preconditions.checkNotNull(closeableReference);
        CloseableReference<CloseableImage> closeableReference2 = null;
        if (imageFormat != null) {
            try {
                if (DefaultImageFormats.isHeifFormatAnimated(imageFormat) && z) {
                    createImageReference = createImageReference(this.mAnimatedHeifFrameCache.cache(i, closeableReference));
                    if (!CloseableReference.isValid(createImageReference)) {
                        CloseableReference.closeSafely(this.mPreparedPendingFrames.get(i));
                    } else {
                        createImageReference = closeableReference2.m2638clone();
                        CloseableReference.closeSafely(this.mPreparedPendingFrames.get(i));
                    }
                    this.mPreparedPendingFrames.put(i, createImageReference);
                    FLog.m464v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
                }
            } finally {
                CloseableReference.closeSafely(closeableReference2);
            }
        }
        closeableReference2 = createImageReference(closeableReference);
        if (closeableReference2 == null) {
            return;
        }
        createImageReference = this.mAnimatedFrameCache.cache(i, closeableReference2);
        if (!CloseableReference.isValid(createImageReference)) {
        }
        this.mPreparedPendingFrames.put(i, createImageReference);
        FLog.m464v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
    }

    private synchronized int getPreparedPendingFramesSizeBytes() {
        int i;
        i = 0;
        for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
            i += getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(i2));
        }
        return i;
    }

    private synchronized void removePreparedReference(int i) {
        CloseableReference<CloseableImage> closeableReference = this.mPreparedPendingFrames.get(i);
        if (closeableReference != null) {
            this.mPreparedPendingFrames.delete(i);
            CloseableReference.closeSafely(closeableReference);
            FLog.m464v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
        }
    }

    @Nullable
    static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableStaticBitmap closeableStaticBitmap;
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap) && (closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get()) != null) {
                return closeableStaticBitmap.cloneUnderlyingBitmapReference();
            }
            CloseableReference.closeSafely(closeableReference);
            return null;
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    private static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (CloseableReference.isValid(closeableReference)) {
            return getBitmapSizeBytes(closeableReference.get());
        }
        return 0;
    }

    private static int getBitmapSizeBytes(@Nullable CloseableImage closeableImage) {
        if (closeableImage instanceof CloseableBitmap) {
            return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
        }
        return 0;
    }

    @Nullable
    private static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        return CloseableReference.m496of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
    }
}
