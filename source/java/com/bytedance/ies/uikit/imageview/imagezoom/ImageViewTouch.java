package com.bytedance.ies.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.common.utility.Logger;

/* loaded from: classes4.dex */
public class ImageViewTouch extends ImageViewTouchBase {
    static final float SCROLL_DELTA_THRESHOLD = 1.0f;
    protected float mCurrentScaleFactor;
    protected int mDoubleTapDirection;
    protected boolean mDoubleTapEnabled;
    private OnImageViewTouchDoubleTapListener mDoubleTapListener;
    protected GestureDetector mGestureDetector;
    protected GestureDetector.OnGestureListener mGestureListener;
    protected View.OnClickListener mListener;
    protected ScaleGestureDetector mScaleDetector;
    protected boolean mScaleEnabled;
    protected float mScaleFactor;
    protected ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    protected boolean mScrollEnabled;
    protected boolean mSingleMode;
    protected int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchDoubleTapListener {
        void onDoubleTap();
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDoubleTapEnabled = true;
        this.mScaleEnabled = true;
        this.mScrollEnabled = true;
        this.mSingleMode = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public void init() {
        super.init();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mGestureListener = getGestureListener();
        this.mScaleListener = getScaleListener();
        this.mScaleDetector = new ScaleGestureDetector(getContext().getApplicationContext(), this.mScaleListener);
        this.mGestureDetector = new GestureDetector(getContext().getApplicationContext(), this.mGestureListener, null, true);
        this.mCurrentScaleFactor = 1.0f;
        this.mDoubleTapDirection = 1;
    }

    public void setMyOnClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setDoubleTapListener(OnImageViewTouchDoubleTapListener onImageViewTouchDoubleTapListener) {
        this.mDoubleTapListener = onImageViewTouchDoubleTapListener;
    }

    public void setDoubleTapEnabled(boolean z) {
        this.mDoubleTapEnabled = z;
    }

    public void setScaleEnabled(boolean z) {
        this.mScaleEnabled = z;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public boolean getDoubleTapEnabled() {
        return this.mDoubleTapEnabled;
    }

    protected GestureDetector.OnGestureListener getGestureListener() {
        return new GestureListener();
    }

    protected ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new ScaleListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public void onBitmapChanged(Drawable drawable) {
        super.onBitmapChanged(drawable);
        float[] fArr = new float[9];
        this.mSuppMatrix.getValues(fArr);
        this.mCurrentScaleFactor = fArr[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public void _setImageDrawable(Drawable drawable, boolean z, Matrix matrix, float f) {
        super._setImageDrawable(drawable, z, matrix, f);
        this.mScaleFactor = getMaxZoom() / 3.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mSingleMode = true;
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mSingleMode = false;
        }
        this.mScaleDetector.onTouchEvent(motionEvent);
        if (!this.mScaleDetector.isInProgress()) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (action == 0) {
            this.mIsAnimationFinished = false;
        } else if (action == 1 && getScale() < getMinZoom()) {
            zoomTo(getMinZoom(), 50.0f);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public void onZoom(float f) {
        super.onZoom(f);
        if (this.mScaleDetector.isInProgress()) {
            return;
        }
        this.mCurrentScaleFactor = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase
    public void onZoomAnimationCompleted(float f) {
        super.onZoomAnimationCompleted(f);
        if (!this.mScaleDetector.isInProgress()) {
            this.mCurrentScaleFactor = f;
        }
        if (f < getMinZoom()) {
            zoomTo(getMinZoom(), 50.0f);
        }
    }

    protected float onDoubleTapPost(float f, float f2) {
        if (this.mDoubleTapDirection == 1) {
            float f3 = this.mScaleFactor;
            if ((2.0f * f3) + f <= f2) {
                return f + f3;
            }
            this.mDoubleTapDirection = -1;
            return f2;
        }
        this.mDoubleTapDirection = 1;
        return 1.0f;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.mScrollEnabled || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || this.mScaleDetector.isInProgress()) {
            return false;
        }
        float scale = getScale();
        if (Logger.debug()) {
            Logger.d("image", "onScroll: " + f + ", " + f2 + " " + scale);
        }
        if (scale == 1.0f && !this.mFitToWidth) {
            return false;
        }
        scrollBy(-f, -f2);
        invalidate();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.mScrollEnabled) {
            return false;
        }
        if (Logger.debug()) {
            Logger.d("image", "onFling: " + f + ", " + f2);
        }
        if (motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || this.mScaleDetector.isInProgress()) {
            return false;
        }
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f) <= 800.0f && Math.abs(f2) <= 800.0f) {
            return false;
        }
        scrollBy(x / 2.0f, y / 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean canScroll(int i) {
        RectF bitmapRect;
        if (getDrawable() == null || (bitmapRect = getBitmapRect()) == null) {
            return false;
        }
        updateRect(bitmapRect, this.mScrollRect);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        return (bitmapRect.right < ((float) rect.right) || i >= 0) ? ((double) Math.abs(bitmapRect.left - this.mScrollRect.left)) > 1.0d : Math.abs(bitmapRect.right - ((float) rect.right)) > 1.0f;
    }

    /* loaded from: classes4.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.i("image", "onDoubleTap. double tap enabled? " + ImageViewTouch.this.mDoubleTapEnabled);
            if (ImageViewTouch.this.mDoubleTapEnabled) {
                float scale = ImageViewTouch.this.getScale();
                ImageViewTouch imageViewTouch = ImageViewTouch.this;
                float min = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(imageViewTouch.onDoubleTapPost(scale, imageViewTouch.getMaxZoom()), ImageViewTouch.this.getMinZoom()));
                ImageViewTouch.this.mCurrentScaleFactor = min;
                ImageViewTouch.this.zoomTo(min, motionEvent.getX(), motionEvent.getY(), 200.0f);
                ImageViewTouch.this.invalidate();
            }
            if (ImageViewTouch.this.mDoubleTapListener != null) {
                ImageViewTouch.this.mDoubleTapListener.onDoubleTap();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (!ImageViewTouch.this.isLongClickable() || ImageViewTouch.this.mScaleDetector.isInProgress()) {
                return;
            }
            ImageViewTouch.this.setPressed(true);
            ImageViewTouch.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return ImageViewTouch.this.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return ImageViewTouch.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ImageViewTouch.this.mListener != null && ImageViewTouch.this.mSingleMode) {
                ImageViewTouch.this.mListener.onClick(ImageViewTouch.this);
                return true;
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes4.dex */
    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Log.d("image", "onScale");
            scaleGestureDetector.getCurrentSpan();
            scaleGestureDetector.getPreviousSpan();
            float scaleFactor = ImageViewTouch.this.mCurrentScaleFactor * scaleGestureDetector.getScaleFactor();
            if (!ImageViewTouch.this.mScaleEnabled) {
                return false;
            }
            float min = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(scaleFactor, ImageViewTouch.this.getMinZoom() - 0.1f));
            ImageViewTouch.this.zoomTo(min, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            ImageViewTouch imageViewTouch = ImageViewTouch.this;
            imageViewTouch.mCurrentScaleFactor = Math.min(imageViewTouch.getMaxZoom(), Math.max(min, ImageViewTouch.this.getMinZoom() - 1.0f));
            ImageViewTouch.this.mDoubleTapDirection = 1;
            ImageViewTouch.this.invalidate();
            return true;
        }
    }
}
