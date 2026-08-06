package com.bytedance.common.wschannel.utils;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class TimeCompactUtil {
    public static final long DEFAULT_TIME_STAMP = 0;

    public static long getTimeStampNanos() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
