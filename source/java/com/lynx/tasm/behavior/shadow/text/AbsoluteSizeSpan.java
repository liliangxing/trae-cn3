package com.lynx.tasm.behavior.shadow.text;

/* loaded from: classes7.dex */
public class AbsoluteSizeSpan extends android.text.style.AbsoluteSizeSpan {
    public AbsoluteSizeSpan(int i) {
        super(i);
    }

    public AbsoluteSizeSpan(int i, boolean z) {
        super(i, z);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbsoluteSizeSpan)) {
            return false;
        }
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
        return absoluteSizeSpan.getDip() == getDip() && absoluteSizeSpan.getSize() == getSize();
    }

    public int hashCode() {
        return ((getDip() ? 1 : 0) * 31) + getSize();
    }
}
