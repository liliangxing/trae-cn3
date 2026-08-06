package com.lynx.tasm.fontface;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public final class FontSettingsKey {
    private final String fontFamily;
    private final float textSize;
    private final String variation;

    public FontSettingsKey(String str, float f, String str2) {
        this.variation = str == null ? "" : str;
        this.textSize = f;
        this.fontFamily = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FontSettingsKey)) {
            return false;
        }
        FontSettingsKey fontSettingsKey = (FontSettingsKey) obj;
        return TextUtils.equals(this.fontFamily, fontSettingsKey.fontFamily) && Float.compare(this.textSize, fontSettingsKey.textSize) == 0 && TextUtils.equals(this.variation, fontSettingsKey.variation);
    }

    public int hashCode() {
        int hashCode = ((this.variation.hashCode() * 31) + Float.floatToIntBits(this.textSize)) * 31;
        String str = this.fontFamily;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
