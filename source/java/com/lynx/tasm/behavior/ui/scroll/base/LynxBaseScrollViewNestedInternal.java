package com.lynx.tasm.behavior.ui.scroll.base;

import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;

/* loaded from: classes7.dex */
public interface LynxBaseScrollViewNestedInternal extends LynxBaseScrollViewInternal, NestedScrollingParent2, NestedScrollingChild2 {
    int getBackwardNestedScrollMode();

    int getForwardNestedScrollMode();

    LynxBaseScrollViewNestedInternal getNestedScrollingParentForType(int i);
}
