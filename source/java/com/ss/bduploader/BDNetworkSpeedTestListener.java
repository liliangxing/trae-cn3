package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDNetworkSpeedTestListener {
    public static final int ContextTypeSpeedTestFailed = 1;
    public static final int ContextTypeSpeedTestSuccess = 0;

    void onSpeedTestContext(int i, int i2, String str);

    int speedTestCheckNetState(int i, int i2);
}
