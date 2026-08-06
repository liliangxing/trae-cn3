package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;

/* loaded from: classes6.dex */
public class ExtraLineHeightSpan implements LineHeightSpan.WithDensity {
    private final float blankLineMulti;
    private final float textLineMulti;

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
    }

    public ExtraLineHeightSpan(float f, float f2) {
        this.blankLineMulti = f;
        this.textLineMulti = f2;
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt, TextPaint textPaint) {
        ReplacementSpan[] replacementSpanArr;
        if (textPaint == null) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt2 = textPaint.getFontMetricsInt();
        if (fontMetricsInt2.descent - fontMetricsInt2.ascent <= 0) {
            return;
        }
        if (!(charSequence instanceof Spanned) || (replacementSpanArr = (ReplacementSpan[]) ((Spanned) charSequence).getSpans(i, i2, ReplacementSpan.class)) == null || replacementSpanArr.length <= 0) {
            float f = isBlank(charSequence.subSequence(i, i2)) ? this.blankLineMulti : this.textLineMulti;
            fontMetricsInt.ascent = Math.round(fontMetricsInt2.ascent * f);
            fontMetricsInt.descent = Math.round(fontMetricsInt2.descent * f);
            fontMetricsInt.top = Math.round(fontMetricsInt2.top * f);
            fontMetricsInt.bottom = Math.round(fontMetricsInt2.bottom * f);
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }
}
