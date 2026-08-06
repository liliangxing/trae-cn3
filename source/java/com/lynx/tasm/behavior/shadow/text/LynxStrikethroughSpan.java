package com.lynx.tasm.behavior.shadow.text;

import android.text.style.StrikethroughSpan;

/* loaded from: classes7.dex */
public class LynxStrikethroughSpan extends StrikethroughSpan {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getSpanTypeId() == ((LynxStrikethroughSpan) obj).getSpanTypeId();
    }

    public int hashCode() {
        return getSpanTypeId() * 31;
    }
}
