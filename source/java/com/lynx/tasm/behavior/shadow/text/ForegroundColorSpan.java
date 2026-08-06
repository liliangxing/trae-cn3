package com.lynx.tasm.behavior.shadow.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ForegroundColorSpan extends MetricAffectingSpan {
    private final int mColor;
    private boolean mDrawStroke = false;
    private int mStrokeColor;
    private float mStrokeWidth;

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
    }

    public ForegroundColorSpan(int i) {
        this.mColor = i;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ForegroundColorSpan) && getForegroundColor() == ((ForegroundColorSpan) obj).getForegroundColor();
    }

    public int getForegroundColor() {
        return this.mColor;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    public void setDrawStroke(boolean z) {
        this.mDrawStroke = z;
    }

    public int hashCode() {
        return getForegroundColor() + 31;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        TextHelper.updateTextPaintColor(textPaint, this.mDrawStroke, this.mColor, this.mStrokeColor, this.mStrokeWidth);
    }
}
