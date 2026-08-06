package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes5.dex */
public class BubbleDrawable extends Drawable {
    private float arrowCenterXPx;
    private float arrowHeightPx;
    private float arrowWidthPx;
    private final Paint backgroundPaint;
    private final Path bubblePath;
    private float cornerRadiusPx;
    private final Paint shadowPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public BubbleDrawable(Context context) {
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        Paint paint2 = new Paint(1);
        this.shadowPaint = paint2;
        this.bubblePath = new Path();
        float f = context.getResources().getDisplayMetrics().density;
        this.cornerRadiusPx = 16.0f * f;
        this.arrowWidthPx = 36.0f * f;
        this.arrowHeightPx = 13.0f * f;
        this.arrowCenterXPx = 53.0f * f;
        paint.setColor(Color.rgb(11, 11, 10));
        paint.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.rgb(11, 11, 10));
        paint2.setStyle(Paint.Style.FILL);
        paint2.setShadowLayer(25.0f * f, 0.0f, f * 12.0f, Color.argb(20, 0, 0, 0));
    }

    public void setColor(int i) {
        this.backgroundPaint.setColor(i);
        this.shadowPaint.setColor(i);
        invalidateSelf();
    }

    public void setArrowCenterX(float f, float f2) {
        this.arrowCenterXPx = f * f2;
        onBoundsChange(getBounds());
        invalidateSelf();
    }

    public void setCornerRadius(float f, float f2) {
        this.cornerRadiusPx = f * f2;
        onBoundsChange(getBounds());
        invalidateSelf();
    }

    public void setArrowSize(float f, float f2, float f3) {
        this.arrowWidthPx = f * f3;
        this.arrowHeightPx = f2 * f3;
        onBoundsChange(getBounds());
        invalidateSelf();
    }

    public void setShadow(float f, float f2, float f3, int i, float f4) {
        this.shadowPaint.setShadowLayer(f * f4, f2 * f4, f3 * f4, i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        buildBubblePath(rect.width(), rect.height());
    }

    private void buildBubblePath(int i, int i2) {
        this.bubblePath.reset();
        if (i <= 0 || i2 <= 0) {
            return;
        }
        float f = i2 - this.arrowHeightPx;
        RectF rectF = new RectF(0.0f, 0.0f, i, f);
        Path path = this.bubblePath;
        float f2 = this.cornerRadiusPx;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        float f3 = this.arrowCenterXPx;
        float f4 = this.arrowWidthPx;
        float f5 = f4 / 2.0f;
        float f6 = f3 - f5;
        float f7 = this.arrowHeightPx;
        Path path2 = new Path();
        path2.moveTo(f6, f);
        float f8 = f + (0.9f * f7);
        path2.cubicTo((0.22f * f4) + f6, f, f6 + (0.38f * f4), f8, f3, f + f7);
        path2.cubicTo(f6 + (0.62f * f4), f8, f6 + (f4 * 0.78f), f, f5 + f3, f);
        path2.close();
        this.bubblePath.op(path2, Path.Op.UNION);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPath(this.bubblePath, this.backgroundPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.backgroundPaint.setAlpha(i);
        this.shadowPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.backgroundPaint.setColorFilter(colorFilter);
        this.shadowPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
