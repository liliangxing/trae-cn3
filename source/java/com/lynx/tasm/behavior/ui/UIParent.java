package com.lynx.tasm.behavior.ui;

import android.view.ViewGroup;

/* loaded from: classes7.dex */
public interface UIParent {
    ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams);

    void invalidate();

    boolean needCustomLayout();

    void requestLayout();
}
