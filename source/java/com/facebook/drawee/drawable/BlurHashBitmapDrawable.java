package com.facebook.drawee.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;

/* loaded from: classes6.dex */
public class BlurHashBitmapDrawable extends BitmapDrawable {
    private Bitmap bitmap;
    private Paint myPaint;
    private ScalingUtils.ScaleType scaleType;
    private int targetHeight;
    private int targetWidth;

    public BlurHashBitmapDrawable(Bitmap bitmap, int i, int i2, ScalingUtils.ScaleType scaleType) {
        super(bitmap);
        Paint paint = new Paint();
        this.myPaint = paint;
        this.bitmap = bitmap;
        this.targetWidth = i;
        this.targetHeight = i2;
        this.scaleType = scaleType;
        paint.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.targetWidth <= 0 || this.targetHeight <= 0) {
            super.draw(canvas);
            return;
        }
        double min = this.scaleType == ScalingUtils.ScaleType.FIT_CENTER ? Math.min((canvas.getWidth() * 1.0d) / this.targetWidth, (canvas.getHeight() * 1.0d) / this.targetHeight) : Math.max((canvas.getWidth() * 1.0d) / this.targetWidth, (canvas.getHeight() * 1.0d) / this.targetHeight);
        double d = this.targetWidth * min;
        double d2 = this.targetHeight * min;
        double width = (canvas.getWidth() - d) / 2.0d;
        double height = (canvas.getHeight() - d2) / 2.0d;
        canvas.drawBitmap(this.bitmap, (Rect) null, new Rect((int) width, (int) height, (int) (width + d), (int) (height + d2)), this.myPaint);
    }
}
