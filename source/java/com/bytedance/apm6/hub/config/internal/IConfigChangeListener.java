package com.bytedance.apm6.hub.config.internal;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IConfigChangeListener {
    void onConfigChanged(JSONObject jSONObject, boolean z);
}
