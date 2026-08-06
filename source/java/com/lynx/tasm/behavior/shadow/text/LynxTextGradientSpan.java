package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.lynx.tasm.behavior.ui.background.BackgroundGradientLayer;

/* loaded from: classes7.dex */
public class LynxTextGradientSpan extends MetricAffectingSpan {
    private Rect mBounds = new Rect();
    private final BackgroundGradientLayer mGradient;

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
    }

    public LynxTextGradientSpan(BackgroundGradientLayer backgroundGradientLayer) {
        this.mGradient = backgroundGradientLayer;
    }

    public void updateBounds(Rect rect) {
        this.mBounds.set(rect);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.mBounds.width() == 0 || this.mBounds.height() == 0) {
            return;
        }
        this.mGradient.setBounds(this.mBounds);
        textPaint.setShader(this.mGradient.getShader());
    }
}
