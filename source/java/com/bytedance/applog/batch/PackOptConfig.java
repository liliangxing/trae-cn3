package com.bytedance.applog.batch;

/* loaded from: classes3.dex */
public class PackOptConfig {
    public static volatile long eventLimitLength = 1048576;
    public static volatile boolean packByLengthEnabled = false;
    public static volatile boolean packLengthCalculateOptEnabled = false;
    public static volatile long packLimitLength = 1572864;
    public static volatile int packMaxEventCount = 2000;
    public static volatile boolean packMultiQueryEnabled;
    public static volatile boolean realtimeEventOptEnabled;
}
