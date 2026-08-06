package com.lynx.tasm.behavior.p000ui.scroll.base;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxBaseScrollViewPublic extends LynxBaseScrollViewAuto, LynxBaseScrollViewHorizontal, LynxBaseScrollViewVertical {
    boolean bounces();

    int currentScrollState();

    void enableBounces(boolean z);

    void enableScroll(boolean z);

    boolean scrollEnabled();

    void stopScrolling();
}
