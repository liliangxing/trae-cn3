package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes7.dex */
public class InlineTextBaselineShiftSpan extends MetricAffectingSpan {
    private BaselineShiftCalculator mBaselineShiftCalculator;
    protected int mValign;
    protected float mValignLength;
    private int mBaselineShift = 0;
    private float mLineHeight = 1.0E21f;

    public void setVerticalAlign(int i, float f) {
        this.mValign = i;
        this.mValignLength = f;
    }

    public int getVerticalAlign() {
        return this.mValign;
    }

    public void setBaselineShiftCalculator(BaselineShiftCalculator baselineShiftCalculator) {
        this.mBaselineShiftCalculator = baselineShiftCalculator;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        BaselineShiftCalculator baselineShiftCalculator;
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        if (fontMetricsInt == null || (baselineShiftCalculator = this.mBaselineShiftCalculator) == null) {
            return;
        }
        int calcBaselineShiftAscender = ((int) baselineShiftCalculator.calcBaselineShiftAscender(this.mValign, this.mValignLength, fontMetricsInt.ascent, fontMetricsInt.descent)) - fontMetricsInt.ascent;
        this.mBaselineShift = calcBaselineShiftAscender;
        textPaint.baselineShift = calcBaselineShiftAscender;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        BaselineShiftCalculator baselineShiftCalculator;
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        if (this.mLineHeight != 1.0E21f && fontMetricsInt != null && (baselineShiftCalculator = this.mBaselineShiftCalculator) != null) {
            float maxFontDescent = baselineShiftCalculator.getMaxFontDescent() - this.mBaselineShiftCalculator.getMaxFontAscent();
            int i = this.mValign;
            if (i == 4) {
                this.mBaselineShift = -((int) ((((Math.ceil(this.mLineHeight) - maxFontDescent) / 2.0d) + fontMetricsInt.ascent) - this.mBaselineShiftCalculator.getMaxFontAscent()));
            } else if (i == 7) {
                this.mBaselineShift = (int) (((Math.ceil(this.mLineHeight) - maxFontDescent) / 2.0d) + (-fontMetricsInt.descent) + this.mBaselineShiftCalculator.getMaxFontDescent());
            }
        }
        textPaint.baselineShift = this.mBaselineShift;
    }
}
