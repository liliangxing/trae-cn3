package com.lynx.tasm.behavior.shadow.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes7.dex */
public class TextDecorationSpan extends CharacterStyle {
    public boolean mLineThrough;
    public int mTextDecorationColor;
    public int mTextDecorationStyle;
    public boolean mUnderline;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }

    public TextDecorationSpan(boolean z, boolean z2, int i, int i2) {
        this.mUnderline = z;
        this.mLineThrough = z2;
        this.mTextDecorationStyle = i;
        this.mTextDecorationColor = i2;
    }
}
