package com.lynx.tasm.behavior.p000ui.scroll.base;

import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxBaseScrollViewVertical {
    void animatedScrollToUnlimitedVertically(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    void animatedScrollToVertically(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback);

    boolean canScrollBackwardsVertically();

    boolean canScrollForwardsVertically();

    int getScrollOffsetVertically();

    int[] getScrollRangeVertically();

    void scrollByUnlimitedVertically(int i);

    void scrollByVertically(int i);

    void scrollToUnlimitedVertically(int i);

    void scrollToVertically(int i);

    void setScrollContentSizeVertically(int i);
}
