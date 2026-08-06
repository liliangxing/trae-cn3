package com.lynx.tasm.behavior.p000ui;

import android.view.ViewGroup;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface UIParent {
    ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams);

    void invalidate();

    boolean needCustomLayout();

    void requestLayout();
}
