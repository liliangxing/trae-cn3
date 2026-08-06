package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    private int mAlpha;

    @Nullable
    private T mAnimationBackend;

    @Nullable
    private Rect mBounds;

    @Nullable
    private ColorFilter mColorFilter;
    private ImageFormat mImageFormat;
    private boolean mIsAnimatedHeifIndividualCacheEnabled;

    public AnimationBackendDelegate(@Nullable T t) {
        this.mImageFormat = null;
        this.mIsAnimatedHeifIndividualCacheEnabled = false;
        this.mAlpha = -1;
        this.mAnimationBackend = t;
    }

    public AnimationBackendDelegate(@Nullable T t, ImageFormat imageFormat) {
        this.mIsAnimatedHeifIndividualCacheEnabled = false;
        this.mAlpha = -1;
        this.mAnimationBackend = t;
        this.mImageFormat = imageFormat;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        T t = this.mAnimationBackend;
        return t != null && t.drawFrame(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicHeight();
    }

    public void setAnimationBackend(@Nullable T t) {
        this.mAnimationBackend = t;
        if (t != null) {
            applyBackendProperties(t);
        }
    }

    @Nullable
    public T getAnimationBackend() {
        return this.mAnimationBackend;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend, com.facebook.fresco.animation.backend.AnimationSourceInfo
    public ImageFormat getImageFormat() {
        return this.mImageFormat;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean isAnimatedHeifIndividualCacheEnabled() {
        T t = this.mAnimationBackend;
        if (t != null) {
            return t.isAnimatedHeifIndividualCacheEnabled();
        }
        return false;
    }

    private void applyBackendProperties(AnimationBackend animationBackend) {
        Rect rect = this.mBounds;
        if (rect != null) {
            animationBackend.setBounds(rect);
        }
        int i = this.mAlpha;
        if (i >= 0 && i <= 255) {
            animationBackend.setAlpha(i);
        }
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean hasCacheFrame(int i) {
        T t = this.mAnimationBackend;
        if (t != null) {
            return t.hasCacheFrame(i);
        }
        return false;
    }
}
