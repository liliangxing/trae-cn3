package com.lynx.tasm.behavior.p000ui.scroll.base;

import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxBaseScrollViewAuto {
    void animatedScrollTo(int[] iArr, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    void animatedScrollToUnlimited(int[] iArr, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    boolean canScrollBackwards();

    boolean canScrollForwards();

    int[] getScrollOffset();

    int[] getScrollRange();

    void scrollBy(int[] iArr);

    void scrollByUnlimited(int[] iArr);

    void scrollTo(int[] iArr);

    void scrollToUnlimited(int[] iArr);

    void setScrollContentSize(int[] iArr);
}
