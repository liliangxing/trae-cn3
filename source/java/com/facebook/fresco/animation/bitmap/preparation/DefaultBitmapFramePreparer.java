package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageOOMOptStrategy;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    private static final Class<?> TAG = DefaultBitmapFramePreparer.class;
    private final Bitmap.Config mBitmapConfig;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private final ExecutorService mExecutorService;
    private final SparseArray<Runnable> mPendingFrameDecodeJobs = new SparseArray<>();
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        int uniqueId = getUniqueId(animationBackend, i);
        synchronized (this.mPendingFrameDecodeJobs) {
            if (this.mPendingFrameDecodeJobs.get(uniqueId) != null) {
                FLog.m463v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                return true;
            }
            if (bitmapFrameCache.contains(i, animationBackend.getImageFormat(), animationBackend.isAnimatedHeifIndividualCacheEnabled())) {
                FLog.m463v(TAG, "Frame %d is cached already.", Integer.valueOf(i));
                return true;
            }
            FrameDecodeRunnable frameDecodeRunnable = new FrameDecodeRunnable(animationBackend, bitmapFrameCache, i, uniqueId);
            this.mPendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
            this.mExecutorService.execute(frameDecodeRunnable);
            return true;
        }
    }

    private static int getUniqueId(AnimationBackend animationBackend, int i) {
        return (animationBackend.hashCode() * 31) + i;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class FrameDecodeRunnable implements Runnable {
        private final AnimationBackend mAnimationBackend;
        private final BitmapFrameCache mBitmapFrameCache;
        private final int mFrameNumber;
        private final int mHashCode;

        public FrameDecodeRunnable(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i;
            this.mHashCode = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mBitmapFrameCache.contains(this.mFrameNumber, this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled())) {
                    FLog.m463v((Class<?>) DefaultBitmapFramePreparer.TAG, "Frame %d is cached already.", Integer.valueOf(this.mFrameNumber));
                    synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                        DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    }
                    return;
                }
                if (prepareFrameAndCache(this.mFrameNumber, 1)) {
                    FLog.m463v((Class<?>) DefaultBitmapFramePreparer.TAG, "Prepared frame frame %d.", Integer.valueOf(this.mFrameNumber));
                } else {
                    FLog.m440e((Class<?>) DefaultBitmapFramePreparer.TAG, "Could not prepare frame %d.", Integer.valueOf(this.mFrameNumber));
                }
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    throw th;
                }
            }
        }

        private boolean prepareFrameAndCache(int i, int i2) {
            CloseableReference<Bitmap> bitmapToReuseForFrame;
            int i3 = 2;
            boolean z = false;
            try {
                try {
                    if (i2 == 1) {
                        bitmapToReuseForFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled());
                    } else {
                        if (i2 != 2) {
                            return false;
                        }
                        try {
                            bitmapToReuseForFrame = DefaultBitmapFramePreparer.this.mPlatformBitmapFactory.createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), DefaultBitmapFramePreparer.this.mBitmapConfig);
                            i3 = -1;
                        } catch (RuntimeException e) {
                            FLog.m479w((Class<?>) DefaultBitmapFramePreparer.TAG, "Failed to create frame bitmap", e);
                            return false;
                        }
                    }
                    z = renderFrameAndCache(i, bitmapToReuseForFrame, i2);
                    CloseableReference.closeSafely(bitmapToReuseForFrame);
                } catch (OutOfMemoryError e2) {
                    ImageOOMOptStrategy strategy = ImageOOMOptStrategy.getStrategy();
                    if (strategy == null || !strategy.isEnableAnimatedOOMOpt()) {
                        throw e2;
                    }
                    strategy.optMemoryWhenAnimatedOOM();
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    i3 = -1;
                }
                return (z || i3 == -1) ? z : prepareFrameAndCache(i, i3);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) null);
            }
        }

        private boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.isValid(closeableReference) || !DefaultBitmapFramePreparer.this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get())) {
                return false;
            }
            FLog.m463v((Class<?>) DefaultBitmapFramePreparer.TAG, "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
            synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i2, this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled());
            }
            return true;
        }
    }
}
