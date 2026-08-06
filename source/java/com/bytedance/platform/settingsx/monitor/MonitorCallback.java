package com.bytedance.platform.settingsx.monitor;

/* loaded from: classes4.dex */
public interface MonitorCallback {
    public static final int TYPE_GET_MODEL = 2;
    public static final int TYPE_GET_SETTINGS = 1;
    public static final int TYPE_OBTAIN = 0;
    public static final int VERSION_SETTINGS_V2 = 0;
    public static final int VERSION_SETTINGS_X = 1;

    void monitorDuration(String str, int i, int i2, long j);
}
