package com.bytedance.android.livesdk.pannel;

import android.view.MotionEvent;

/* loaded from: classes2.dex */
public interface SheetSlideProcessor {
    boolean disableDragDown();

    default boolean inIndicatorArea(MotionEvent motionEvent) {
        return false;
    }

    default boolean shouldInterceptSlide(int i) {
        return true;
    }
}
