package com.bytedance.mobsec.metasec.ml;

/* loaded from: classes4.dex */
public class MSC {
    public static final long AB_INIT_SWITCH_ON = 2;
    public static final long AB_MOTION_EVENT_ON = 256;
    public static final long AB_SWITCH_OFF = 0;
    public static final long DEFAULT_DELAY_TIME = 0;
    private static volatile long a = 2;
    private static volatile long b;

    public static long GetABSwitch() {
        return a;
    }

    public static long GetDelayTime() {
        return b;
    }

    public static void SetABSwitch(long j) {
        a = j;
    }

    public static void SetDelayTime(long j) {
        b = j;
    }
}
