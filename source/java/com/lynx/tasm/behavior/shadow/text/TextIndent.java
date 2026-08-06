package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableArray;

/* loaded from: classes7.dex */
public class TextIndent {
    private static final int TYPE_VALUE_NUMBER = 0;
    private final int mType;
    private final float mValue;

    public TextIndent(ReadableArray readableArray) {
        this.mValue = (float) readableArray.getDouble(0);
        this.mType = readableArray.getInt(1);
    }

    public float getValue(float f) {
        return this.mType == 0 ? this.mValue : f * this.mValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return this.mValue == textIndent.mValue && this.mType == textIndent.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + Float.floatToIntBits(this.mValue);
    }
}
