package com.lynx.tasm.behavior.shadow.text;

/* loaded from: classes7.dex */
public class BackgroundColorSpan extends android.text.style.BackgroundColorSpan {
    public BackgroundColorSpan(int i) {
        super(i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof BackgroundColorSpan) && getBackgroundColor() == ((BackgroundColorSpan) obj).getBackgroundColor();
    }

    public int hashCode() {
        return getBackgroundColor() + 31;
    }
}
