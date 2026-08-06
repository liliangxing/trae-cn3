package com.bytedance.tobshadow.applog;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface ISessionObserver {
    void onSessionBatchEvent(long j, String str, JSONObject jSONObject);

    void onSessionStart(long j, String str);

    void onSessionTerminate(long j, String str, JSONObject jSONObject);
}
