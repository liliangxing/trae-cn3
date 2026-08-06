package io.noties.markwon.ext.tasklist;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class TaskListDrawable extends Drawable {
    private static final Point POINT_0 = new Point(0.15277778f, 0.45833334f);
    private static final Point POINT_1 = new Point(0.3888889f, 0.6944444f);
    private static final Point POINT_2 = new Point(0.8472222f, 0.2638889f);
    private final Paint checkMarkPaint;
    private final Path checkMarkPath;
    private final int checkedFillColor;
    private boolean isChecked;
    private final int normalOutlineColor;
    private final Paint paint = new Paint(1);
    private final RectF rectF = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public TaskListDrawable(int i, int i2, int i3) {
        Paint paint = new Paint(1);
        this.checkMarkPaint = paint;
        this.checkMarkPath = new Path();
        this.checkedFillColor = i;
        this.normalOutlineColor = i2;
        paint.setColor(i3);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float min = Math.min(rect.width(), rect.height());
        float f = min / 8.0f;
        float f2 = min - f;
        this.rectF.set(0.0f, 0.0f, f2, f2);
        this.paint.setStrokeWidth(f);
        this.checkMarkPaint.setStrokeWidth(f);
        this.checkMarkPath.reset();
        POINT_0.moveTo(this.checkMarkPath, f2);
        POINT_1.lineTo(this.checkMarkPath, f2);
        POINT_2.lineTo(this.checkMarkPath, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint.Style style;
        int i;
        if (this.isChecked) {
            style = Paint.Style.FILL_AND_STROKE;
            i = this.checkedFillColor;
        } else {
            style = Paint.Style.STROKE;
            i = this.normalOutlineColor;
        }
        this.paint.setStyle(style);
        this.paint.setColor(i);
        Rect bounds = getBounds();
        float width = (bounds.width() - this.rectF.width()) / 2.0f;
        float height = (bounds.height() - this.rectF.height()) / 2.0f;
        float width2 = this.rectF.width() / 8.0f;
        int save = canvas.save();
        try {
            canvas.translate(width, height);
            canvas.drawRoundRect(this.rectF, width2, width2, this.paint);
            if (this.isChecked) {
                canvas.drawPath(this.checkMarkPath, this.checkMarkPaint);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z;
        int length = iArr != null ? iArr.length : 0;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (16842912 == iArr[i]) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = z != this.isChecked;
        if (z2) {
            invalidateSelf();
            this.isChecked = z;
        }
        return z2;
    }

    /* loaded from: classes7.dex */
    private static class Point {
        final float x;
        final float y;

        Point(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        void moveTo(Path path, float f) {
            path.moveTo(this.x * f, f * this.y);
        }

        void lineTo(Path path, float f) {
            path.lineTo(this.x * f, f * this.y);
        }
    }
}
