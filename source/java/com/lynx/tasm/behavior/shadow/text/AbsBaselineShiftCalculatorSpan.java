package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes7.dex */
public abstract class AbsBaselineShiftCalculatorSpan extends ReplacementSpan {
    private BaselineShiftCalculator mBaselineShiftCalculator;
    protected int mCalcAscent = 0;
    protected boolean mEnableTextRefactor = false;
    protected int mValign;
    protected float mValignLength;

    protected abstract int getIncludeMarginHeight();

    public void setVerticalAlign(int i, float f) {
        this.mValign = i;
        this.mValignLength = f;
    }

    public int getVerticalAlign() {
        return this.mValign;
    }

    public void setEnableTextRefactor(boolean z) {
        this.mEnableTextRefactor = z;
    }

    public void setBaselineShiftCalculator(BaselineShiftCalculator baselineShiftCalculator) {
        this.mBaselineShiftCalculator = baselineShiftCalculator;
    }

    public float calcBaselineShiftAscender(float f, float f2) {
        BaselineShiftCalculator baselineShiftCalculator = this.mBaselineShiftCalculator;
        return baselineShiftCalculator != null ? baselineShiftCalculator.calcBaselineShiftAscender(this.mValign, this.mValignLength, f, f2) : f;
    }

    public void AdjustFontMetrics(Paint.FontMetricsInt fontMetricsInt) {
        int i = fontMetricsInt.ascent;
        int i2 = this.mCalcAscent;
        if (i > i2) {
            fontMetricsInt.ascent = i2;
        }
        int i3 = fontMetricsInt.top;
        int i4 = this.mCalcAscent;
        if (i3 > i4) {
            fontMetricsInt.top = i4;
        }
        int includeMarginHeight = this.mCalcAscent + getIncludeMarginHeight();
        if (fontMetricsInt.descent < includeMarginHeight) {
            fontMetricsInt.descent = includeMarginHeight;
        }
        if (fontMetricsInt.bottom < includeMarginHeight) {
            fontMetricsInt.bottom = includeMarginHeight;
        }
    }
}
