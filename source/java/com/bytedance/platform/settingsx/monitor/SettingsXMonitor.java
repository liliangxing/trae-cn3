package com.bytedance.platform.settingsx.monitor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class SettingsXMonitor {
    private static MonitorCallback sCallback;
    private static Executor sExecutor;
    private static Map<String, Integer> sHaveObtainMap = new ConcurrentHashMap();

    public static void monitorDuration(String str, int i, int i2, long j) {
    }

    public static void setExecutor(Executor executor) {
        sExecutor = executor;
    }

    public static void setCallback(MonitorCallback monitorCallback) {
        sCallback = monitorCallback;
    }
}
