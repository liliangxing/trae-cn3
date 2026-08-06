package com.lynx.tasm.behavior.shadow.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomStyleSpan extends MetricAffectingSpan {
    private final String mFontFamily;
    private final String mFontFeatureSettings;
    private final String mFontVariationSettings;
    private final boolean mHasValidTypeface;
    private final int mStyle;
    private final int mWeight;

    public CustomStyleSpan(int i, int i2, String str, String str2, String str3, boolean z) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFontFamily = str;
        this.mFontVariationSettings = str2;
        this.mFontFeatureSettings = str3;
        this.mHasValidTypeface = z;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(TextPaint textPaint) {
        TextHelper.updateTextPaintTypeFace(textPaint, this.mFontFamily, this.mStyle, this.mWeight, this.mFontVariationSettings, this.mFontFeatureSettings, this.mHasValidTypeface);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomStyleSpan customStyleSpan = (CustomStyleSpan) obj;
        return this.mStyle == customStyleSpan.mStyle && this.mWeight == customStyleSpan.mWeight;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mStyle), Integer.valueOf(this.mWeight));
    }

    public int getStyle() {
        return this.mStyle;
    }
}
