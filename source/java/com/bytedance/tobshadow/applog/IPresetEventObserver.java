package com.bytedance.tobshadow.applog;

import org.json.JSONObject;

@Deprecated
/* loaded from: classes5.dex */
public interface IPresetEventObserver {
    void onLaunch(JSONObject jSONObject);

    void onPageEnter(JSONObject jSONObject);

    void onPageLeave(JSONObject jSONObject);
}
