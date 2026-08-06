package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.MeasureMode;

/* loaded from: classes7.dex */
public class TextRendererKey {
    final boolean enableTailColorConvert;
    public final float height;
    final MeasureMode heightMode;
    final BaseKey mBaseKey;
    final boolean mEnableTextBoringLayout;
    final boolean mEnabledTextRefactor;
    public final float width;
    final MeasureMode widthMode;
    final int wordBreakStrategy;

    /* loaded from: classes7.dex */
    public static class BaseKey {
        final TextAttributes mAttributes;
        CharSequence mText;

        BaseKey(CharSequence charSequence, TextAttributes textAttributes) {
            this.mText = charSequence;
            this.mAttributes = textAttributes;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BaseKey)) {
                return false;
            }
            BaseKey baseKey = (BaseKey) obj;
            CharSequence charSequence = this.mText;
            if (charSequence == null && baseKey.mText != null) {
                return false;
            }
            if (charSequence != null && !charSequence.equals(baseKey.mText)) {
                return false;
            }
            TextAttributes textAttributes = this.mAttributes;
            if (textAttributes != null || baseKey.mAttributes == null) {
                return textAttributes == null || textAttributes.equals(baseKey.mAttributes);
            }
            return false;
        }

        public int hashCode() {
            CharSequence charSequence = this.mText;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            TextAttributes textAttributes = this.mAttributes;
            return hashCode + (textAttributes != null ? textAttributes.hashCode() : 0);
        }
    }

    public TextRendererKey(CharSequence charSequence, TextAttributes textAttributes, MeasureMode measureMode, MeasureMode measureMode2, float f, float f2, int i, boolean z, boolean z2, boolean z3) {
        this.mBaseKey = new BaseKey(charSequence, textAttributes);
        this.width = f;
        this.height = f2;
        this.widthMode = measureMode;
        this.heightMode = measureMode2;
        this.wordBreakStrategy = i;
        this.enableTailColorConvert = z;
        this.mEnabledTextRefactor = z2;
        this.mEnableTextBoringLayout = z3;
    }

    public TextAttributes getAttributes() {
        return this.mBaseKey.mAttributes;
    }

    public CharSequence getSpan() {
        return this.mBaseKey.mText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSpan(CharSequence charSequence) {
        this.mBaseKey.mText = charSequence;
    }

    boolean isValid() {
        return !(this.widthMode != MeasureMode.UNDEFINED && this.heightMode != MeasureMode.UNDEFINED && this.width == 0.0f && this.height == 0.0f);
    }

    public String toString() {
        return ((Object) this.mBaseKey.mText) + " " + this.width + " " + this.height;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TextRendererKey)) {
            return false;
        }
        TextRendererKey textRendererKey = (TextRendererKey) obj;
        return this.mBaseKey.equals(textRendererKey.mBaseKey) && this.widthMode == textRendererKey.widthMode && this.heightMode == textRendererKey.heightMode && this.width == textRendererKey.width && this.height == textRendererKey.height && this.wordBreakStrategy == textRendererKey.wordBreakStrategy && this.enableTailColorConvert == textRendererKey.enableTailColorConvert && this.mEnabledTextRefactor == textRendererKey.mEnabledTextRefactor && this.mEnableTextBoringLayout == textRendererKey.mEnableTextBoringLayout;
    }

    public int hashCode() {
        return (((((((((((((((this.mBaseKey.hashCode() * 31) + this.widthMode.hashCode()) * 31) + this.heightMode.hashCode()) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + this.wordBreakStrategy) * 31) + (this.enableTailColorConvert ? 1 : 0)) * 31) + (this.mEnabledTextRefactor ? 1 : 0)) * 31) + (this.mEnableTextBoringLayout ? 1 : 0);
    }
}
