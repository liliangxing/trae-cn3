package com.bytedance.sdk.account.utils;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IMonitor {
    void onEvent(String str, JSONObject jSONObject);

    void setAppLogInfo(long j, String str);
}
