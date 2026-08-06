package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* loaded from: classes7.dex */
public class FontFamilySpan extends MetricAffectingSpan {
    private final Typeface mTypeface;

    public FontFamilySpan(Typeface typeface) {
        this.mTypeface = typeface;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mTypeface, ((FontFamilySpan) obj).mTypeface);
    }

    public int hashCode() {
        Typeface typeface = this.mTypeface;
        if (typeface == null) {
            return 0;
        }
        return typeface.hashCode();
    }
}
