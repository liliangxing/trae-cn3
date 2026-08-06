package com.lynx.tasm.behavior.shadow.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.lynx.tasm.behavior.ui.ShadowData;

/* loaded from: classes7.dex */
public class ShadowStyleSpan extends CharacterStyle {
    private final ShadowData mTextShadow;

    public ShadowStyleSpan(ShadowData shadowData) {
        this.mTextShadow = shadowData;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.mTextShadow.blurRadius, this.mTextShadow.offsetX, this.mTextShadow.offsetY, this.mTextShadow.color);
    }
}
