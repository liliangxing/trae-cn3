package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ISessionObserver {
    void onSessionBatchEvent(long j, String str, JSONObject jSONObject);

    void onSessionStart(long j, String str);

    void onSessionTerminate(long j, String str, JSONObject jSONObject);
}
