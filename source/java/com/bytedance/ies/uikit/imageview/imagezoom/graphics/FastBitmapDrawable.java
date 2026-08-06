package com.bytedance.ies.uikit.imageview.imagezoom.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class FastBitmapDrawable extends Drawable implements IBitmapDrawable {
    protected Bitmap mBitmap;
    protected Paint mPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FastBitmapDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setDither(true);
        this.mPaint.setFilterBitmap(true);
    }

    public FastBitmapDrawable(Resources resources, InputStream inputStream) {
        this(BitmapFactory.decodeStream(inputStream));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mBitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mBitmap.getHeight();
    }

    public void setAntiAlias(boolean z) {
        this.mPaint.setAntiAlias(z);
        invalidateSelf();
    }

    @Override // com.bytedance.ies.uikit.imageview.imagezoom.graphics.IBitmapDrawable
    public Bitmap getBitmap() {
        return this.mBitmap;
    }
}
