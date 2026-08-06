package com.bytedance.apm.npth;

import java.util.Map;

/* loaded from: classes3.dex */
public class NpthUtil {
    private static boolean hasStart;
    private static IMonitorListener sMonitorListener;
    private static INpthCallback sNpthCallback;

    /* loaded from: classes3.dex */
    public interface IGetUserData {
        Map<String, String> getUserData();
    }

    /* loaded from: classes3.dex */
    public interface IMonitorListener {
        void startMonitor();
    }

    /* loaded from: classes3.dex */
    public interface INpthCallback {
        void addAttachUserData(IGetUserData iGetUserData);

        void addTags(Map<String, String> map);
    }

    public static void setMonitorListener(IMonitorListener iMonitorListener) {
        sMonitorListener = iMonitorListener;
    }

    public static void startMonitor() {
        IMonitorListener iMonitorListener;
        if (hasStart || (iMonitorListener = sMonitorListener) == null) {
            return;
        }
        iMonitorListener.startMonitor();
        hasStart = true;
    }

    public static void setNpthCallback(INpthCallback iNpthCallback) {
        sNpthCallback = iNpthCallback;
    }

    public static void addNpthTags(Map<String, String> map) {
        INpthCallback iNpthCallback = sNpthCallback;
        if (iNpthCallback != null) {
            iNpthCallback.addTags(map);
        }
    }

    public static void addNpthUserData(IGetUserData iGetUserData) {
        INpthCallback iNpthCallback = sNpthCallback;
        if (iNpthCallback != null) {
            iNpthCallback.addAttachUserData(iGetUserData);
        }
    }
}
