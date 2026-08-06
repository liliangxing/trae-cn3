package com.bytedance.applog.collector;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface NavigatorCallback {
    void onPause(String str, JSONObject jSONObject);

    void onResume(String str, JSONObject jSONObject);
}
