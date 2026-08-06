package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.util.AnimationBackendUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private static final Class<?> TAG = BitmapAnimationBackend.class;
    private final AnimationInformation mAnimationInformation;
    private final BitmapFrameCache mBitmapFrameCache;

    @Nullable
    private BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;

    @Nullable
    private final BitmapFramePreparer mBitmapFramePreparer;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private int mBitmapHeight;
    private int mBitmapWidth;

    @Nullable
    private Rect mBounds;

    @Nullable
    private FrameListener mFrameListener;

    @Nullable
    private ImageFormat mImageFormat;
    private boolean mIsAnimHeifIndividualCacheForCurrentRequestEnabled;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private int mLastDrawnFrameNumber = -1;
    private final Paint mPaint = new Paint(6);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        updateBitmapDimensions();
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    public void setFrameListener(@Nullable FrameListener frameListener) {
        this.mFrameListener = frameListener;
    }

    public void setBitmapFramePreparationStrategy(BitmapFramePreparationStrategy bitmapFramePreparationStrategy) {
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setAnimHeifIndividualCacheForCurrentRequestEnabled(boolean z) {
        this.mIsAnimHeifIndividualCacheForCurrentRequestEnabled = z;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    public AnimationInformation getAnimationInformation() {
        return this.mAnimationInformation;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        boolean drawFrameOrFallback;
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        FrameListener frameListener2 = this.mFrameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i);
        }
        if (DefaultImageFormats.isHeifFormatAnimated(this.mImageFormat)) {
            drawFrameOrFallback = drawFrameForHeif(canvas, i);
        } else {
            drawFrameOrFallback = drawFrameOrFallback(canvas, i, 0);
        }
        if (!drawFrameOrFallback && (frameListener = this.mFrameListener) != null) {
            frameListener.onFrameDropped(this, i);
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy != null && (bitmapFramePreparer = this.mBitmapFramePreparer) != null) {
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.mBitmapFrameCache, this, i);
        }
        return drawFrameOrFallback;
    }

    private boolean drawFrameOrFallback(Canvas canvas, int i, int i2) {
        CloseableReference<Bitmap> cachedFrame;
        boolean drawBitmapAndCache;
        boolean z = false;
        int i3 = 1;
        try {
            if (i2 == 0) {
                cachedFrame = this.mBitmapFrameCache.getCachedFrame(i, this.mImageFormat, isAnimatedHeifIndividualCacheEnabled());
                drawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 0);
            } else if (i2 == 1) {
                cachedFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mBitmapWidth, this.mBitmapHeight, this.mImageFormat, isAnimatedHeifIndividualCacheEnabled());
                if (renderFrameInBitmap(i, cachedFrame) && drawBitmapAndCache(i, cachedFrame, canvas, 1)) {
                    z = true;
                }
                drawBitmapAndCache = z;
                i3 = 2;
            } else if (i2 == 2) {
                cachedFrame = this.mPlatformBitmapFactory.createBitmap(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                if (renderFrameInBitmap(i, cachedFrame) && drawBitmapAndCache(i, cachedFrame, canvas, 2)) {
                    z = true;
                }
                drawBitmapAndCache = z;
                i3 = 3;
            } else {
                if (i2 != 3) {
                    return false;
                }
                cachedFrame = this.mBitmapFrameCache.getFallbackFrame(i);
                drawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 3);
                i3 = -1;
            }
            CloseableReference.closeSafely(cachedFrame);
            return (drawBitmapAndCache || i3 == -1) ? drawBitmapAndCache : drawFrameOrFallback(canvas, i, i3);
        } catch (RuntimeException e) {
            FLog.m479w(TAG, "Failed to create frame bitmap", e);
            return false;
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) null);
        }
    }

    private boolean drawFrameForHeif(Canvas canvas, int i) {
        boolean z;
        CloseableReference<Bitmap> closeableReference = null;
        try {
            boolean z2 = false;
            if (i == this.mLastDrawnFrameNumber) {
                closeableReference = this.mBitmapFrameCache.getFallbackFrame(i);
                z = drawBitmapAndCache(i, closeableReference, canvas, 3);
            } else {
                z = false;
            }
            if (!z) {
                closeableReference = this.mBitmapFrameCache.getCachedFrame(i, this.mImageFormat, isAnimatedHeifIndividualCacheEnabled());
                z = drawBitmapAndCache(i, closeableReference, canvas, 1);
            }
            if (!z) {
                try {
                    closeableReference = this.mPlatformBitmapFactory.createBitmap(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                    if (renderFrameInBitmap(i, closeableReference) && drawBitmapAndCache(i, closeableReference, canvas, 2)) {
                        z2 = true;
                    }
                    z = z2;
                } catch (Throwable th) {
                    FLog.m479w(TAG, "Failed to create frame bitmap for render heif frame", th);
                    CloseableReference.closeSafely(closeableReference);
                    return false;
                }
            }
            CloseableReference.closeSafely(closeableReference);
            this.mLastDrawnFrameNumber = i;
            return z;
        } catch (Throwable th2) {
            CloseableReference.closeSafely(closeableReference);
            throw th2;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        this.mBounds = rect;
        this.mBitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.mBitmapFrameCache.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend, com.facebook.fresco.animation.backend.AnimationSourceInfo
    public ImageFormat getImageFormat() {
        return this.mImageFormat;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean isAnimatedHeifIndividualCacheEnabled() {
        return AnimationBackendUtil.isUseIndividualCacheForCurrentAnimHeifRequest(this.mIsAnimHeifIndividualCacheForCurrentRequestEnabled);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.mBitmapFrameCache.clear(this.mImageFormat, getFrameCount(), isAnimatedHeifIndividualCacheEnabled());
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean hasCacheFrame(int i) {
        return this.mBitmapFrameCache.contains(i, this.mImageFormat, isAnimatedHeifIndividualCacheEnabled());
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        if (DefaultImageFormats.isHeifFormatAnimated(this.mImageFormat) && (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() || ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled())) {
            return;
        }
        clear();
    }

    private void updateBitmapDimensions() {
        int intrinsicWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
        this.mBitmapWidth = intrinsicWidth;
        if (intrinsicWidth == -1) {
            Rect rect = this.mBounds;
            this.mBitmapWidth = rect == null ? -1 : rect.width();
        }
        int intrinsicHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
        this.mBitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.mBounds;
            this.mBitmapHeight = rect2 != null ? rect2.height() : -1;
        }
    }

    private boolean renderFrameInBitmap(int i, @Nullable CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        boolean renderFrame = this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get());
        if (!renderFrame) {
            CloseableReference.closeSafely(closeableReference);
        }
        return renderFrame;
    }

    private boolean drawBitmapAndCache(int i, @Nullable CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        try {
            if (this.mBounds == null) {
                canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(closeableReference.get(), (Rect) null, this.mBounds, this.mPaint);
            }
        } catch (Exception e) {
            FLog.m439e(TAG, "canvas draw error: ", e);
        }
        if (i2 != 3) {
            this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2, this.mImageFormat, isAnimatedHeifIndividualCacheEnabled());
        }
        FrameListener frameListener = this.mFrameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, i, i2);
        return true;
    }
}
