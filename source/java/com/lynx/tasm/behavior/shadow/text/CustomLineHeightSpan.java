package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomLineHeightSpan implements LineHeightSpan.WithDensity {
    private final boolean mEnableTextRefactor;
    private final int mHeight;
    private final boolean mIsSingLineAndOverflowClip;
    private final int mTextSingleLineVerticalAlign;

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
    }

    public CustomLineHeightSpan(float f, boolean z, int i, boolean z2) {
        if (f == 1.0E21f) {
            this.mHeight = 0;
        } else {
            this.mHeight = (int) Math.ceil(f);
        }
        this.mEnableTextRefactor = z;
        this.mTextSingleLineVerticalAlign = i;
        this.mIsSingLineAndOverflowClip = z2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CustomLineHeightSpan) && this.mHeight == ((CustomLineHeightSpan) obj).mHeight;
    }

    public int hashCode() {
        return this.mHeight + 31;
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt, TextPaint textPaint) {
        Rect rect;
        if (this.mEnableTextRefactor) {
            if (this.mTextSingleLineVerticalAlign == 0 || !(charSequence.length() == i2 - i || this.mIsSingLineAndOverflowClip)) {
                rect = null;
            } else {
                rect = new Rect();
                if (Build.VERSION.SDK_INT >= 29) {
                    textPaint.getTextBounds(charSequence, 0, charSequence.toString().length(), rect);
                } else {
                    textPaint.getTextBounds(charSequence.toString(), 0, charSequence.toString().length(), rect);
                }
            }
            int i5 = this.mHeight;
            if (i5 != 0 && rect == null) {
                TextHelper.calcTextTranslateTopOffsetAndAdjustFontMetric(i5, fontMetricsInt, false);
                for (AbsBaselineShiftCalculatorSpan absBaselineShiftCalculatorSpan : (AbsBaselineShiftCalculatorSpan[]) ((SpannableStringBuilder) charSequence).getSpans(i, i2, AbsBaselineShiftCalculatorSpan.class)) {
                    absBaselineShiftCalculatorSpan.AdjustFontMetrics(fontMetricsInt);
                }
                return;
            }
            if (rect != null) {
                if (i5 == 0) {
                    i5 = fontMetricsInt.bottom - fontMetricsInt.top;
                }
                int i6 = this.mTextSingleLineVerticalAlign;
                if (i6 == 4) {
                    int i7 = rect.top;
                    fontMetricsInt.ascent = i7;
                    fontMetricsInt.top = i7;
                    int i8 = i5 + fontMetricsInt.top;
                    fontMetricsInt.descent = i8;
                    fontMetricsInt.bottom = i8;
                    return;
                }
                if (i6 == 7) {
                    int i9 = rect.bottom;
                    fontMetricsInt.descent = i9;
                    fontMetricsInt.bottom = i9;
                    int i10 = fontMetricsInt.bottom - i5;
                    fontMetricsInt.ascent = i10;
                    fontMetricsInt.top = i10;
                    return;
                }
                if (i6 == 11) {
                    int height = rect.top - ((i5 - rect.height()) / 2);
                    fontMetricsInt.top = height;
                    fontMetricsInt.ascent = height;
                    int i11 = fontMetricsInt.top + i5;
                    fontMetricsInt.bottom = i11;
                    fontMetricsInt.descent = i11;
                    return;
                }
                return;
            }
            return;
        }
        if (this.mHeight != 0) {
            int i12 = fontMetricsInt.descent;
            int i13 = this.mHeight;
            if (i12 > i13) {
                int min = Math.min(i13, fontMetricsInt.descent);
                fontMetricsInt.descent = min;
                fontMetricsInt.bottom = min;
                fontMetricsInt.ascent = 0;
                fontMetricsInt.top = 0;
                return;
            }
            if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.mHeight) {
                fontMetricsInt.bottom = fontMetricsInt.descent;
                int i14 = (-this.mHeight) + fontMetricsInt.descent;
                fontMetricsInt.ascent = i14;
                fontMetricsInt.top = i14;
                return;
            }
            if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.mHeight) {
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = fontMetricsInt.ascent + this.mHeight;
                return;
            }
            if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.mHeight) {
                fontMetricsInt.top = fontMetricsInt.bottom - this.mHeight;
                return;
            }
            int round = Math.round((r4 - ((-fontMetricsInt.top) + fontMetricsInt.bottom)) / 2.0f);
            int round2 = Math.round((this.mHeight - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2.0f);
            fontMetricsInt.top -= round;
            fontMetricsInt.bottom += round;
            fontMetricsInt.ascent -= round2;
            fontMetricsInt.descent += round2;
        }
    }
}
