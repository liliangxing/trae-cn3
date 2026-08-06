package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxBaseScrollViewInternal extends LynxBaseScrollViewPublic {
    int[] dispatchScroll(int i, int i2, int i3, MotionEvent motionEvent, int[] iArr);

    int[] getFlingRange(boolean z);

    int getNestedScrollAxes();

    int getScrollX();

    int getScrollY();

    View getView();

    boolean isBouncingBackwards(int i, int[] iArr);

    boolean isBouncingForwards(int i, int[] iArr);

    boolean isVertical();

    boolean startNestedScroll(int i, int i2);

    void stopNestedScroll(int i);
}
