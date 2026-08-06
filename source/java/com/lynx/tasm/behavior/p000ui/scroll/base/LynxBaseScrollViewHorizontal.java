package com.lynx.tasm.behavior.p000ui.scroll.base;

import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxBaseScrollViewHorizontal {
    void animatedScrollToHorizontally(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    void animatedScrollToUnlimitedHorizontally(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    boolean canScrollBackwardsHorizontally();

    boolean canScrollForwardsHorizontally();

    int getScrollOffsetHorizontally();

    int[] getScrollRangeHorizontally();

    void scrollByHorizontally(int i);

    void scrollByUnlimitedHorizontally(int i);

    void scrollToHorizontally(int i);

    void scrollToUnlimitedHorizontally(int i);

    void setScrollContentSizeHorizontally(int i);
}
