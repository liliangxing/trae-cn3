package com.lynx.tasm.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.lynx.tasm.image.ScalingUtils;
import java.util.Objects;

/* loaded from: classes7.dex */
public class LynxScaleTypeDrawable extends Drawable {
    String mCapInsets;
    String mCapInsetsScale;
    private ImageContent mCurrentDelegate;
    Matrix mDrawMatrix;
    ScalingUtils.ScaleType mScaleType;
    Object mScaleTypeState;
    int mUnderlyingWidth = 0;
    int mUnderlyingHeight = 0;
    private Matrix mTempMatrix = new Matrix();

    public LynxScaleTypeDrawable(ImageContent imageContent, ScalingUtils.ScaleType scaleType) {
        this.mCurrentDelegate = imageContent;
        this.mScaleType = scaleType;
    }

    public Drawable getAnimDrawable() {
        ImageContent imageContent = this.mCurrentDelegate;
        if (imageContent != null) {
            return imageContent.getDrawable();
        }
        return null;
    }

    public void setCurrent(ImageContent imageContent) {
        setCurrent(imageContent, true);
    }

    public void setCurrent(ImageContent imageContent, boolean z) {
        this.mCurrentDelegate = imageContent;
        if (z) {
            configureBounds();
        }
    }

    public void setCapInsets(String str, String str2) {
        this.mCapInsets = str;
        this.mCapInsetsScale = str2;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (Objects.equals(this.mScaleType, scaleType)) {
            return;
        }
        this.mScaleType = scaleType;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.mCurrentDelegate != null) {
            configureBoundsIfUnderlyingChanged();
            if (!TextUtils.isEmpty(this.mCapInsets) && (bitmap = this.mCurrentDelegate.getBitmap()) != null) {
                NinePatchHelper.drawNinePatch(getBounds().width(), getBounds().height(), bitmap.getWidth(), bitmap.getHeight(), this.mScaleType, this.mCapInsets, this.mCapInsetsScale, canvas, this.mCurrentDelegate.getBitmap());
                return;
            }
            if (this.mDrawMatrix != null) {
                int save = canvas.save();
                canvas.clipRect(getBounds());
                canvas.concat(this.mDrawMatrix);
                this.mCurrentDelegate.draw(canvas);
                canvas.restoreToCount(save);
                return;
            }
            this.mCurrentDelegate.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        ImageContent imageContent = this.mCurrentDelegate;
        if (imageContent != null) {
            imageContent.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        ImageContent imageContent = this.mCurrentDelegate;
        if (imageContent != null) {
            imageContent.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        ImageContent imageContent = this.mCurrentDelegate;
        if (imageContent == null) {
            return 0;
        }
        return imageContent.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (getContent() != null) {
            configureBounds();
        }
    }

    private void configureBoundsIfUnderlyingChanged() {
        if ((this.mUnderlyingWidth == getContent().getIntrinsicWidth() && this.mUnderlyingHeight == getContent().getIntrinsicHeight()) ? false : true) {
            configureBounds();
        }
    }

    public ImageContent getContent() {
        return this.mCurrentDelegate;
    }

    void configureBounds() {
        ImageContent content = getContent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = content.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = content.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            content.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        if (intrinsicWidth == width && intrinsicHeight == height) {
            content.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
            content.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            content.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mScaleType.getTransform(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, 0.5f, 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    public void releaseImageSource() {
        ImageContent imageContent = this.mCurrentDelegate;
        if (imageContent != null) {
            imageContent.releaseImageResource();
        }
    }
}
