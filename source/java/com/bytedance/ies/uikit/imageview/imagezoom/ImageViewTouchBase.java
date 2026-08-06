package com.bytedance.ies.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.ies.uikit.imageview.imagezoom.easing.Cubic;
import com.bytedance.ies.uikit.imageview.imagezoom.easing.Easing;
import com.bytedance.ies.uikit.imageview.imagezoom.graphics.FastBitmapDrawable;
import com.bytedance.ies.uikit.imageview.imagezoom.utils.IDisposable;

/* loaded from: classes4.dex */
public class ImageViewTouchBase extends ImageView implements IDisposable {
    public static final String LOG_TAG = "image";
    protected static final float MIN_ZOOM = 0.9f;
    protected final int DEFAULT_ANIMATION_DURATION;
    protected final float MAX_ZOOM;
    protected Matrix mBaseMatrix;
    protected RectF mBitmapRect;
    protected RectF mCenterRect;
    protected final Matrix mDisplayMatrix;
    protected Easing mEasing;
    protected boolean mFitToScreen;
    protected boolean mFitToWidth;
    protected Handler mHandler;
    protected boolean mIsAnimationFinished;
    private OnBitmapChangedListener mListener;
    protected final float[] mMatrixValues;
    protected float mMaxZoom;
    protected float mMinZoom;
    protected Runnable mOnLayoutRunnable;
    protected RectF mScrollRect;
    protected Matrix mSuppMatrix;
    protected int mThisHeight;
    protected int mThisWidth;

    /* loaded from: classes4.dex */
    public interface OnBitmapChangedListener {
        void onBitmapChanged(Drawable drawable);
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    protected float minZoom() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onZoom(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onZoomAnimationCompleted(float f) {
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.mEasing = new Cubic();
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mOnLayoutRunnable = null;
        this.mMinZoom = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mFitToWidth = false;
        this.mFitToScreen = false;
        this.MAX_ZOOM = 2.5f;
        this.DEFAULT_ANIMATION_DURATION = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEasing = new Cubic();
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mOnLayoutRunnable = null;
        this.mMinZoom = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mFitToWidth = false;
        this.mFitToScreen = false;
        this.MAX_ZOOM = 2.5f;
        this.DEFAULT_ANIMATION_DURATION = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        init();
    }

    public void setOnBitmapChangedListener(OnBitmapChangedListener onBitmapChangedListener) {
        this.mListener = onBitmapChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void clear() {
        setImageBitmap(null, true);
    }

    public void setFitToScreen(boolean z) {
        if (z != this.mFitToScreen) {
            this.mFitToScreen = z;
            requestLayout();
        }
    }

    public void setFitToWidth(boolean z) {
        if (z != this.mFitToWidth) {
            this.mFitToWidth = z;
            requestLayout();
        }
    }

    public void setMinZoom(float f) {
        Log.d("image", "minZoom: " + f);
        this.mMinZoom = f;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mThisWidth = i3 - i;
        this.mThisHeight = i4 - i2;
        Runnable runnable = this.mOnLayoutRunnable;
        if (runnable != null) {
            this.mOnLayoutRunnable = null;
            runnable.run();
        }
        if (getDrawable() != null) {
            float f = 1.0f;
            if (this.mFitToWidth) {
                float[] fArr = new float[1];
                getProperBaseMatrix3(getDrawable(), this.mBaseMatrix, fArr);
                setMinZoom(fArr[0]);
            } else if (this.mFitToScreen) {
                getProperBaseMatrix2(getDrawable(), this.mBaseMatrix);
                setMinZoom(1.0f);
                f = getMinZoom();
            } else {
                getProperBaseMatrix(getDrawable(), this.mBaseMatrix);
                setMinZoom(getMinZoom());
                f = getMinZoom();
            }
            setImageMatrix(getImageViewMatrix());
            zoomTo(f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, true);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setImageBitmap(Bitmap bitmap, boolean z) {
        setImageBitmap(bitmap, z, null);
    }

    public void setImageBitmap(Bitmap bitmap, boolean z, Matrix matrix) {
        setImageBitmap(bitmap, z, matrix, -1.0f);
    }

    public void setImageBitmap(Bitmap bitmap, boolean z, Matrix matrix, float f) {
        if (bitmap != null) {
            setImageDrawable(new FastBitmapDrawable(bitmap), z, matrix, f);
        } else {
            setImageDrawable(null, z, matrix, f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true, null, -1.0f);
    }

    public void setImageDrawable(final Drawable drawable, final boolean z, final Matrix matrix, final float f) {
        if (getWidth() <= 0) {
            this.mOnLayoutRunnable = new Runnable() { // from class: com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageViewTouchBase.this.setImageDrawable(drawable, z, matrix, f);
                }
            };
        } else {
            _setImageDrawable(drawable, z, matrix, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _setImageDrawable(Drawable drawable, boolean z, Matrix matrix, float f) {
        if (drawable != null) {
            if (this.mFitToWidth) {
                float[] fArr = new float[1];
                getProperBaseMatrix3(drawable, this.mBaseMatrix, fArr);
                setMinZoom(fArr[0]);
            } else if (this.mFitToScreen) {
                getProperBaseMatrix2(drawable, this.mBaseMatrix);
                setMinZoom(getScale(this.mBaseMatrix));
            } else {
                getProperBaseMatrix(drawable, this.mBaseMatrix);
                setMinZoom(getMinZoom());
            }
            super.setImageDrawable(drawable);
        } else {
            this.mBaseMatrix.reset();
            super.setImageDrawable(null);
        }
        if (z) {
            this.mSuppMatrix.reset();
            if (matrix != null) {
                this.mSuppMatrix = new Matrix(matrix);
            }
        }
        setImageMatrix(getImageViewMatrix());
        if (f < 1.0f) {
            this.mMaxZoom = maxZoom();
        } else {
            this.mMaxZoom = f;
        }
        onBitmapChanged(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBitmapChanged(Drawable drawable) {
        OnBitmapChangedListener onBitmapChangedListener = this.mListener;
        if (onBitmapChangedListener != null) {
            onBitmapChangedListener.onBitmapChanged(drawable);
        }
    }

    protected float maxZoom() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.max(r0.getIntrinsicWidth() / this.mThisWidth, r0.getIntrinsicHeight() / this.mThisHeight) * 4.0f;
    }

    public float getMaxZoom() {
        if (this.mMaxZoom < 1.0f) {
            this.mMaxZoom = maxZoom();
        }
        return this.mMaxZoom;
    }

    public float getMinZoom() {
        if (this.mMinZoom < 0.0f) {
            this.mMinZoom = minZoom();
        }
        return this.mMinZoom;
    }

    public Matrix getImageViewMatrix() {
        return getImageViewMatrix(this.mSuppMatrix);
    }

    public Matrix getImageViewMatrix(Matrix matrix) {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(matrix);
        return this.mDisplayMatrix;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.mSuppMatrix);
    }

    protected void getProperBaseMatrix(Drawable drawable, Matrix matrix) {
        Log.i("image", "getProperBaseMatrix");
        float width = getWidth();
        float height = getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth > width || intrinsicHeight > height) {
            float min = Math.min(Math.min(width / intrinsicWidth, 2.0f), Math.min(height / intrinsicHeight, 2.0f));
            Log.d("image", "scale: " + min);
            matrix.postScale(min, min);
            matrix.postTranslate((width - (intrinsicWidth * min)) / 2.0f, (height - (intrinsicHeight * min)) / 2.0f);
            return;
        }
        matrix.postTranslate((width - intrinsicWidth) / 2.0f, (height - intrinsicHeight) / 2.0f);
        Log.d("image", "scale: null");
    }

    protected void getProperBaseMatrix2(Drawable drawable, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float min = Math.min(Math.min(width / intrinsicWidth, 2.5f), Math.min(height / intrinsicHeight, 2.5f));
        matrix.postScale(min, min);
        matrix.postTranslate((width - (intrinsicWidth * min)) / 2.0f, (height - (intrinsicHeight * min)) / 2.0f);
    }

    protected void getProperBaseMatrix3(Drawable drawable, Matrix matrix, float[] fArr) {
        float width = getWidth();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        matrix.reset();
        float min = Math.min(width / intrinsicWidth, 2.5f);
        Log.d("ImageViewTouchBase", "get scale3 " + min + " " + intrinsicWidth + " " + width);
        matrix.postScale(min, min);
        matrix.postTranslate((width - (intrinsicWidth * min)) / 2.0f, 0.0f);
        if (min > 1.0f) {
            fArr[0] = 1.0f / min;
        } else {
            fArr[0] = 1.0f;
        }
    }

    protected float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF getBitmapRect() {
        return getBitmapRect(this.mSuppMatrix);
    }

    protected RectF getBitmapRect(Matrix matrix) {
        Drawable drawable = getDrawable();
        Matrix imageViewMatrix = getImageViewMatrix(matrix);
        if (drawable != null) {
            this.mBitmapRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        } else {
            this.mBitmapRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        imageViewMatrix.mapRect(this.mBitmapRect);
        return this.mBitmapRect;
    }

    protected float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    protected void center(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF center = getCenter(this.mSuppMatrix, z, z2);
        if (center.left == 0.0f && center.top == 0.0f) {
            return;
        }
        Log.d("image", "center.rect: " + center.left + "x" + center.top);
        postTranslate(center.left, center.top);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected RectF getCenter(Matrix matrix, boolean z, boolean z2) {
        float f;
        float f2;
        float f3;
        float height;
        float f4;
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.mCenterRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF bitmapRect = getBitmapRect(matrix);
        float height2 = bitmapRect.height();
        float width = bitmapRect.width();
        if (z2) {
            float height3 = getHeight();
            if (height2 < height3) {
                height = (height3 - height2) / 2.0f;
                f4 = bitmapRect.top;
            } else {
                if (bitmapRect.top > 0.0f) {
                    f = -bitmapRect.top;
                    if (z) {
                        float width2 = getWidth();
                        if (width < width2) {
                            width2 = (width2 - width) / 2.0f;
                            f3 = bitmapRect.left;
                        } else {
                            if (bitmapRect.left > 0.0f) {
                                f2 = -bitmapRect.left;
                                this.mCenterRect.set(f2, f, 0.0f, 0.0f);
                                return this.mCenterRect;
                            }
                            if (bitmapRect.right < width2) {
                                f3 = bitmapRect.right;
                            }
                        }
                        f2 = width2 - f3;
                        this.mCenterRect.set(f2, f, 0.0f, 0.0f);
                        return this.mCenterRect;
                    }
                    f2 = 0.0f;
                    this.mCenterRect.set(f2, f, 0.0f, 0.0f);
                    return this.mCenterRect;
                }
                if (bitmapRect.bottom < height3) {
                    height = getHeight();
                    f4 = bitmapRect.bottom;
                }
            }
            f = height - f4;
            if (z) {
            }
            f2 = 0.0f;
            this.mCenterRect.set(f2, f, 0.0f, 0.0f);
            return this.mCenterRect;
        }
        f = 0.0f;
        if (z) {
        }
        f2 = 0.0f;
        this.mCenterRect.set(f2, f, 0.0f, 0.0f);
        return this.mCenterRect;
    }

    protected void postTranslate(float f, float f2) {
        this.mSuppMatrix.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postScale(float f, float f2, float f3) {
        this.mSuppMatrix.postScale(f, f, f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    protected void zoomTo(float f) {
        zoomTo(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public void zoomTo(float f, float f2) {
        zoomTo(f, getWidth() / 2.0f, getHeight() / 2.0f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        float f4 = this.mMaxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        Log.d("image", "zoomTo: " + f + ", center: " + f2 + "x" + f3);
        postScale(scale, f2, f3);
        onZoom(getScale());
        center(true, true);
    }

    public void scrollBy(float f, float f2) {
        panBy(f, f2);
    }

    protected void panBy(double d, double d2) {
        RectF bitmapRect = getBitmapRect();
        this.mScrollRect.set((float) d, (float) d2, 0.0f, 0.0f);
        updateRect(bitmapRect, this.mScrollRect);
        postTranslate(this.mScrollRect.left, this.mScrollRect.top);
        center(true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRect(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        if (rectF.top >= 0.0f && rectF.bottom <= height) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= width) {
            rectF2.left = 0.0f;
        }
        if (rectF.top + rectF2.top >= 0.0f && rectF.bottom > height) {
            rectF2.top = (int) (0.0f - rectF.top);
        }
        if (rectF.bottom + rectF2.top <= height - 0.0f && rectF.top < 0.0f) {
            rectF2.top = (int) (r1 - rectF.bottom);
        }
        if (rectF.left + rectF2.left >= 0.0f) {
            rectF2.left = (int) (0.0f - rectF.left);
        }
        if (rectF.right + rectF2.left <= width - 0.0f) {
            rectF2.left = (int) (r0 - rectF.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scrollBy(float f, float f2, final double d) {
        final double d2 = f;
        final double d3 = f2;
        final long currentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() { // from class: com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase.2
            double old_x = 0.0d;
            double old_y = 0.0d;

            @Override // java.lang.Runnable
            public void run() {
                double min = Math.min(d, System.currentTimeMillis() - currentTimeMillis);
                double easeOut = ImageViewTouchBase.this.mEasing.easeOut(min, 0.0d, d2, d);
                double easeOut2 = ImageViewTouchBase.this.mEasing.easeOut(min, 0.0d, d3, d);
                ImageViewTouchBase.this.panBy(easeOut - this.old_x, easeOut2 - this.old_y);
                this.old_x = easeOut;
                this.old_y = easeOut2;
                if (min < d) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                RectF center = imageViewTouchBase.getCenter(imageViewTouchBase.mSuppMatrix, true, true);
                if (center.left == 0.0f && center.top == 0.0f) {
                    return;
                }
                ImageViewTouchBase.this.scrollBy(center.left, center.top);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3, final float f4) {
        if (f > getMaxZoom()) {
            f = getMaxZoom();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final float scale = getScale();
        final float f5 = f - scale;
        Matrix matrix = new Matrix(this.mSuppMatrix);
        matrix.postScale(f, f, f2, f3);
        RectF center = getCenter(matrix, true, true);
        final float f6 = f2 + (center.left * f);
        final float f7 = f3 + (center.top * f);
        this.mHandler.post(new Runnable() { // from class: com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase.3
            @Override // java.lang.Runnable
            public void run() {
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale + ((float) ImageViewTouchBase.this.mEasing.easeInOut(min, 0.0d, f5, f4)), f6, f7);
                if (min < f4) {
                    ImageViewTouchBase.this.mHandler.post(this);
                    return;
                }
                if (ImageViewTouchBase.this.mIsAnimationFinished) {
                    ImageViewTouchBase.this.mIsAnimationFinished = false;
                    return;
                }
                ImageViewTouchBase.this.mIsAnimationFinished = true;
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                imageViewTouchBase.onZoomAnimationCompleted(imageViewTouchBase.getScale());
                ImageViewTouchBase.this.center(true, true);
            }
        });
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.utils.IDisposable
    public void dispose() {
        clear();
    }
}
