package com.lynx.tasm.behavior.shadow.text;

import android.text.style.UnderlineSpan;

/* loaded from: classes7.dex */
public class LynxUnderlineSpan extends UnderlineSpan {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getSpanTypeId() == ((LynxUnderlineSpan) obj).getSpanTypeId();
    }

    public int hashCode() {
        return getSpanTypeId() * 31;
    }
}
