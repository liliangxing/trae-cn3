package com.lynx.tasm.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class ImageContent {
    private Rect dst;
    private float mAlpha;
    private Bitmap mBitmap;
    private int mBottom;
    private Drawable mDrawable;
    private boolean mIsBitmap;
    private int mLeft;
    private Paint mPaint;
    private ReleasableImage mReleasableBitmap;
    private int mRight;
    private int mTop;
    private Rect src;

    public ImageContent(ReleasableImage releasableImage) {
        this.mAlpha = 1.0f;
        this.mReleasableBitmap = releasableImage;
        if (releasableImage.getBitmap() != null) {
            this.mBitmap = this.mReleasableBitmap.getBitmap();
            this.mIsBitmap = true;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.src = new Rect(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
            return;
        }
        if (releasableImage.getDrawable() != null) {
            this.mDrawable = releasableImage.getDrawable();
        }
    }

    public ImageContent(Bitmap bitmap) {
        this.mAlpha = 1.0f;
        this.mBitmap = bitmap;
        this.mIsBitmap = true;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.src = new Rect(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    public ImageContent(Drawable drawable) {
        this.mAlpha = 1.0f;
        this.mDrawable = drawable;
    }

    public void releaseImageResource() {
        ReleasableImage releasableImage = this.mReleasableBitmap;
        if (releasableImage != null) {
            releasableImage.release();
        }
    }

    public int getIntrinsicWidth() {
        if (this.mIsBitmap) {
            return this.mBitmap.getWidth();
        }
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.mIsBitmap) {
            return this.mBitmap.getHeight();
        }
        return this.mDrawable.getIntrinsicHeight();
    }

    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.mIsBitmap) {
            if (this.dst == null) {
                this.dst = new Rect();
            }
            if (this.mLeft != i || this.mRight != i3 || this.mTop != i2 || this.mBottom != i4) {
                this.dst.set(i, i2, i3, i4);
            }
            this.mLeft = i;
            this.mTop = i2;
            this.mRight = i3;
            this.mBottom = i4;
            return;
        }
        this.mDrawable.setBounds(i, i2, i3, i4);
    }

    public void draw(Canvas canvas) {
        if (this.mIsBitmap) {
            canvas.drawBitmap(this.mBitmap, this.src, this.dst, this.mPaint);
        } else {
            this.mDrawable.draw(canvas);
        }
    }

    public final Bitmap getBitmap() {
        if (this.mIsBitmap) {
            return this.mBitmap;
        }
        Drawable drawable = this.mDrawable;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setAlpha(int i) {
        if (!this.mIsBitmap) {
            this.mDrawable.setAlpha(i);
            return;
        }
        float f = i;
        if (this.mAlpha != f) {
            this.mAlpha = f;
            this.mPaint.setAlpha(i);
        }
    }

    public int getOpacity() {
        if (this.mIsBitmap) {
            Bitmap bitmap = this.mBitmap;
            return (bitmap == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255) ? -3 : -1;
        }
        return this.mDrawable.getOpacity();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mIsBitmap) {
            this.mPaint.setColorFilter(colorFilter);
        } else {
            this.mDrawable.setColorFilter(colorFilter);
        }
    }

    public final void setCallback(Drawable.Callback callback) {
        if (this.mIsBitmap) {
            return;
        }
        this.mDrawable.setCallback(callback);
    }

    public void setFilterBitmap(boolean z) {
        if (this.mIsBitmap) {
            this.mPaint.setFilterBitmap(z);
        } else {
            this.mDrawable.setFilterBitmap(z);
        }
    }
}
