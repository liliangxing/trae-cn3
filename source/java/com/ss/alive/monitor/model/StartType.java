package com.ss.alive.monitor.model;

import com.bytedance.push.proxy.ActivityTaskManagerHooker;

/* loaded from: classes7.dex */
public enum StartType {
    START_SERVICE("startService", "start_service"),
    BIND_SERVICE("bindIsolatedService", "bind_service"),
    PROVIDER_GET_TYPE("getProviderMimeType", "provider_get_type"),
    PROVIDER_QUERY("getContentProvider", "provider_query"),
    SEND_BROADCAST("broadcastIntent", "send_broadcast"),
    START_ACTIVITY(ActivityTaskManagerHooker.METHOD_START_ACTIVITY, "start_activity");

    public final String methodName;
    public final String startType;

    StartType(String str, String str2) {
        this.methodName = str;
        this.startType = str2;
    }
}
