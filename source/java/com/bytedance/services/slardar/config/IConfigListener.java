package com.bytedance.services.slardar.config;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IConfigListener {
    void onReady();

    void onRefresh(JSONObject jSONObject, boolean z);
}
