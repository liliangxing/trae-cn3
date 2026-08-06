package com.bytedance.apm.listener;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IApmLogListener {
    void onLog(String str, String str2, JSONObject jSONObject);
}
