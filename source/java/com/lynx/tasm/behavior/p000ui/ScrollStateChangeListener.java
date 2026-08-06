package com.lynx.tasm.behavior.p000ui;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ScrollStateChangeListener {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    void onScrollStateChanged(int i);
}
