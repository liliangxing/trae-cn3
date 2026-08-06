package com.bytedance.tobshadow.applog;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IPullAbTestConfigCallback {
    void onRemoteConfig(JSONObject jSONObject);

    void onThrottle(long j);

    void onTimeoutError();
}
