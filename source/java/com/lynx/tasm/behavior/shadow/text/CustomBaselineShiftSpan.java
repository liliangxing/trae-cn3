package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ReplacementSpan;

/* loaded from: classes7.dex */
public class CustomBaselineShiftSpan extends ReplacementSpan {
    final int mEnd;
    final float mShift;
    final int mStart;
    private final int mTextVerticalAlign;

    public CustomBaselineShiftSpan(int i, int i2, int i3, float f) {
        this.mStart = i;
        this.mEnd = i2;
        this.mTextVerticalAlign = i3;
        this.mShift = f;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return Math.round(paint.measureText(charSequence, i, i2));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        float f2;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (charSequence instanceof Spannable) {
            drawBackgroundIfNeed(canvas, (Spannable) charSequence, i, i2, f, i3, i4, i5, paint);
        }
        int i7 = this.mTextVerticalAlign;
        if (i7 == 0) {
            i6 = -Math.round(fontMetrics.top);
        } else if (i7 == 2) {
            i6 = i5 - Math.round(fontMetrics.leading);
        } else if (i7 == 1) {
            i6 = (int) (i3 + Math.round(Math.abs(fontMetrics.ascent)) + (((i5 - i3) - (fontMetrics.descent - fontMetrics.ascent)) / 2.0f));
            if (fontMetrics.leading == 0.0f) {
                f2 = i6 + ((fontMetrics.descent / 2.0f) - paint.getStrokeMiter());
                i6 = (int) f2;
            }
        } else if (i7 == 3) {
            f2 = i4 + this.mShift;
            i6 = (int) f2;
        } else {
            i6 = i4;
        }
        canvas.drawText(charSequence, i, i2, f, i6, paint);
    }

    private void drawBackgroundIfNeed(Canvas canvas, Spannable spannable, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spannable.getSpans(i, i2, BackgroundColorSpan.class);
        if (backgroundColorSpanArr == null || backgroundColorSpanArr.length == 0) {
            return;
        }
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(backgroundColorSpanArr[0].getBackgroundColor());
        Rect rect = new Rect(Math.round(f), i3, Math.round(f + paint.measureText(spannable, i, i2)), i5);
        rect.offset(0, Math.round(this.mShift));
        canvas.drawRect(rect, paint2);
    }
}
