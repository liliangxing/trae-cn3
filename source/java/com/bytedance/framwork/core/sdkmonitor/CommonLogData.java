package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class CommonLogData {
    JSONObject logData;
    String logType;
    long timestamp;

    public CommonLogData(String str, JSONObject jSONObject, long j) {
        this.logType = str;
        this.logData = jSONObject;
        this.timestamp = j;
    }
}
