package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes7.dex */
public class NativeLayoutNodeSpan extends AbsBaselineShiftCalculatorSpan {
    private int mBaseline;
    private int mHeight;
    private int mIndex;
    private int mWidth;

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
    }

    public NativeLayoutNodeSpan() {
        if (this.mEnableTextRefactor) {
            this.mValign = 1;
        } else {
            this.mValign = 0;
        }
        this.mValignLength = 0.0f;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void updateLayoutNodeSize(int i, int i2, int i3) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mBaseline = i3;
    }

    public void setSpanIndex(int i) {
        this.mIndex = i;
    }

    public int getSpanIndex() {
        return this.mIndex;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int i3;
        if (fontMetricsInt != null) {
            if (fontMetricsInt.descent == fontMetricsInt.ascent) {
                fontMetricsInt.ascent = paint.getFontMetricsInt().ascent;
                fontMetricsInt.descent = paint.getFontMetricsInt().descent;
            }
            if (this.mEnableTextRefactor) {
                if (getVerticalAlign() == 1 && (i3 = this.mBaseline) != 0) {
                    this.mCalcAscent = -i3;
                } else {
                    this.mCalcAscent = (int) calcBaselineShiftAscender(-this.mHeight, 0.0f);
                }
            } else {
                this.mCalcAscent = caYOffset(fontMetricsInt);
            }
            if (fontMetricsInt.ascent > this.mCalcAscent) {
                fontMetricsInt.ascent = this.mCalcAscent;
            }
            if (fontMetricsInt.descent < this.mCalcAscent + this.mHeight) {
                fontMetricsInt.descent = this.mCalcAscent + this.mHeight;
            }
            if (fontMetricsInt.top > fontMetricsInt.ascent) {
                fontMetricsInt.top = fontMetricsInt.ascent;
            }
            if (fontMetricsInt.bottom < fontMetricsInt.descent) {
                fontMetricsInt.bottom = fontMetricsInt.descent;
            }
        }
        return this.mWidth;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    private int caYOffset(Paint.FontMetricsInt fontMetricsInt) {
        int i;
        float f;
        int i2;
        int i3;
        int i4 = fontMetricsInt.descent - fontMetricsInt.ascent;
        int i5 = this.mHeight;
        switch (this.mValign) {
            case 1:
                return -i5;
            case 2:
                i = fontMetricsInt.descent - i5;
                f = i4 * 0.1f;
                return i - ((int) f);
            case 3:
                i2 = fontMetricsInt.ascent;
                i3 = (int) (i4 * 0.1f);
                return i2 + i3;
            case 4:
            case 5:
                return fontMetricsInt.ascent;
            case 6:
            default:
                i2 = fontMetricsInt.ascent;
                i3 = (i4 - i5) / 2;
                return i2 + i3;
            case 7:
            case 8:
                return fontMetricsInt.descent - i5;
            case 9:
                i = -i5;
                f = this.mValignLength;
                return i - ((int) f);
        }
    }

    public int getYOffset(int i, int i2, int i3, int i4) {
        if (!this.mEnableTextRefactor) {
            return (i2 - i4) - this.mHeight;
        }
        int i5 = this.mValign;
        if (i5 == 4) {
            return i;
        }
        if (i5 == 7) {
            return i2 - this.mHeight;
        }
        if (i5 == 11) {
            return ((i2 + i) - this.mHeight) / 2;
        }
        return (i - i3) + this.mCalcAscent;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsBaselineShiftCalculatorSpan
    protected int getIncludeMarginHeight() {
        return this.mHeight;
    }
}
