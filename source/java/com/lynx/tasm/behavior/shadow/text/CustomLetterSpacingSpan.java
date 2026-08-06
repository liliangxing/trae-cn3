package com.lynx.tasm.behavior.shadow.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes7.dex */
public class CustomLetterSpacingSpan extends MetricAffectingSpan {
    private final float mLetterSpacing;

    public CustomLetterSpacingSpan(float f) {
        this.mLetterSpacing = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(TextPaint textPaint) {
        if (Float.isNaN(this.mLetterSpacing)) {
            return;
        }
        textPaint.setLetterSpacing(this.mLetterSpacing / textPaint.getTextSize());
    }
}
