package com.bytedance.tobshadow.applog;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IEventJsonObserver {
    void eventJson(String str, JSONObject jSONObject);

    void launchJson(JSONObject jSONObject);

    void pageJson(JSONObject jSONObject, boolean z);
}
