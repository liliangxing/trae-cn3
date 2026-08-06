package com.lynx.tasm.behavior.ui.scroll.base;

/* loaded from: classes7.dex */
public interface LynxBaseScrollViewPublic extends LynxBaseScrollViewAuto, LynxBaseScrollViewHorizontal, LynxBaseScrollViewVertical {
    boolean bounces();

    int currentScrollState();

    void enableBounces(boolean z);

    void enableScroll(boolean z);

    boolean scrollEnabled();

    void stopScrolling();
}
