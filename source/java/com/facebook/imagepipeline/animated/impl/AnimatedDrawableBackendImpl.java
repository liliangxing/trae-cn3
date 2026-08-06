package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.util.AnimationBackendUtil;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.animated.factory.AnimatedTempBitmapFactory;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    private boolean isFromTempBitmapFactory;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImage mAnimatedImage;
    private final AnimatedImageResult mAnimatedImageResult;
    private final int mDurationMs;
    private final int[] mFrameDurationsMs;
    private final AnimatedDrawableFrameInfo[] mFrameInfos;
    private final int[] mFrameTimestampsMs;
    private final Rect mRenderedBounds;

    @Nullable
    private Bitmap mTempBitmap;
    private final Rect mRenderSrcRect = new Rect();
    private final Rect mRenderDstRect = new Rect();
    private int mDecodeType = 2;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.mAnimatedImage = image;
        int[] frameDurations = image.getFrameDurations();
        this.mFrameDurationsMs = frameDurations;
        animatedDrawableUtil.fixFrameDurations(frameDurations);
        this.mDurationMs = animatedDrawableUtil.getTotalDurationFromFrameDurations(frameDurations);
        this.mFrameTimestampsMs = animatedDrawableUtil.getFrameTimeStampsFromDurations(frameDurations);
        this.mRenderedBounds = getBoundsToUse(image, rect);
        this.mFrameInfos = new AnimatedDrawableFrameInfo[image.getFrameCount()];
        for (int i = 0; i < this.mAnimatedImage.getFrameCount(); i++) {
            this.mFrameInfos[i] = this.mAnimatedImage.getFrameInfo(i);
        }
    }

    private static Rect getBoundsToUse(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.mDurationMs;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mFrameInfos[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int i) {
        Preconditions.checkElementIndex(i, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int i) {
        return this.mFrameDurationsMs[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean isAnimatedHeifIndividualCacheEnabled() {
        return AnimationBackendUtil.isUseIndividualCacheForCurrentAnimHeifRequest(this.mAnimatedImageResult.isUseIndividualCacheForHeif());
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        return getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds) ? this : new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized int getMemoryUsage() {
        Bitmap bitmap;
        bitmap = this.mTempBitmap;
        return (bitmap != null ? 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(bitmap) : 0) + this.mAnimatedImage.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.getDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.hasDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.mAnimatedImage.getFrame(i);
        try {
            if (this.mAnimatedImage.doesRenderSupportScaling()) {
                renderImageSupportsScaling(canvas, frame);
            } else {
                renderImageDoesNotSupportScaling(canvas, frame);
            }
        } finally {
            frame.dispose();
        }
    }

    private synchronized void prepareTempBitmapForThisSize(int i, int i2) {
        Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null && (bitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            AnimatedTempBitmapFactory animatedTempBitmapFactory = AnimatedFactoryProvider.getAnimatedTempBitmapFactory();
            Bitmap createBitmap = animatedTempBitmapFactory != null ? animatedTempBitmapFactory.createBitmap(i, i2, Bitmap.Config.ARGB_8888, this.mDecodeType) : null;
            if (createBitmap != null) {
                this.mTempBitmap = createBitmap;
                this.isFromTempBitmapFactory = true;
            } else {
                if (i <= 0) {
                    i = 10;
                }
                if (i2 <= 0) {
                    i2 = 10;
                }
                this.mTempBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.isFromTempBitmapFactory = false;
            }
        }
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = this.mRenderedBounds.width() / this.mAnimatedImage.getWidth();
        double height = this.mRenderedBounds.height() / this.mAnimatedImage.getHeight();
        int round = (int) Math.round(animatedImageFrame.getWidth() * width);
        int round2 = (int) Math.round(animatedImageFrame.getHeight() * height);
        int xOffset = (int) (animatedImageFrame.getXOffset() * width);
        int yOffset = (int) (animatedImageFrame.getYOffset() * height);
        synchronized (this) {
            int width2 = this.mRenderedBounds.width();
            int height2 = this.mRenderedBounds.height();
            prepareTempBitmapForThisSize(width2, height2);
            synchronized (this.mTempBitmap) {
                this.mTempBitmap.eraseColor(0);
                try {
                    animatedImageFrame.renderFrame(round, round2, this.mTempBitmap);
                    this.mRenderSrcRect.set(0, 0, width2, height2);
                    this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
                    canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e.getMessage() + parseExtraInfo(this.mTempBitmap, round, round2, this.mRenderedBounds, this.mDecodeType));
                }
            }
        }
    }

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width = animatedImageFrame.getWidth();
        int height = animatedImageFrame.getHeight();
        int xOffset = animatedImageFrame.getXOffset();
        int yOffset = animatedImageFrame.getYOffset();
        synchronized (this) {
            prepareTempBitmapForThisSize(width, height);
            synchronized (this.mTempBitmap) {
                this.mTempBitmap.eraseColor(0);
                try {
                    animatedImageFrame.renderFrame(width, height, this.mTempBitmap);
                    this.mRenderSrcRect.set(0, 0, width, height);
                    this.mRenderDstRect.set(0, 0, width, height);
                    canvas.save();
                    canvas.translate(xOffset, yOffset);
                    canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
                    canvas.restore();
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e.getMessage() + parseExtraInfo(this.mTempBitmap, width, height, null, this.mDecodeType));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        clearTempBitmap();
    }

    private synchronized void clearTempBitmap() {
        Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null) {
            if (!this.isFromTempBitmapFactory) {
                bitmap.recycle();
            }
            this.mTempBitmap = null;
        }
    }

    public void setDecodeType(int i) {
        this.mDecodeType = i;
    }

    private String parseExtraInfo(Bitmap bitmap, int i, int i2, Rect rect, int i3) {
        StringBuilder append = new StringBuilder(", mTempBitmap:").append(bitmap.getWidth()).append("x").append(bitmap.getHeight()).append(", frame:").append(i).append("x").append(i2);
        if (rect != null) {
            append.append(", renderedBounds:").append(rect.width()).append("x").append(rect.height());
        }
        append.append(", decodeType:").append(i3);
        return append.toString();
    }
}
