package com.bytedance.android.monitor.webview.gecko;

/* loaded from: classes3.dex */
public abstract class IMonitorGeckoClient {
    public static final String VERSION = "2.2.1";

    public abstract void checkAndInit();

    public final String getAccessKey() {
        return "5194cf52a842a932b45e2da53553c014";
    }

    public final String getChannel() {
        return "slardar_js";
    }

    public abstract String getResourcePath();

    public final String getVersion() {
        return "2.2.1";
    }
}
