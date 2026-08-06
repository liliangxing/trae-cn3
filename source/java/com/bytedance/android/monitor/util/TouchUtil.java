package com.bytedance.android.monitor.util;

import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class TouchUtil {
    private static long lastTouchDownTime;

    public static void touch(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return;
        }
        lastTouchDownTime = System.currentTimeMillis();
    }

    public static long getLastTouchTime() {
        if (lastTouchDownTime == 0) {
            lastTouchDownTime = System.currentTimeMillis();
        }
        return lastTouchDownTime;
    }
}
