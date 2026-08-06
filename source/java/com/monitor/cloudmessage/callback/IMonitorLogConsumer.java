package com.monitor.cloudmessage.callback;

import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IMonitorLogConsumer {
    void handleLogData(long j, long j2, String str, IMonitorLogQueryCallback iMonitorLogQueryCallback);

    void notifyLogDataConsumed(String str, String str2);

    String[] parseLogType(JSONObject jSONObject);
}
