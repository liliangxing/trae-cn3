package com.bytedance.android.monitor.webview.cache.base;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface INativeInfoCache {
    boolean isCanReport();

    void reset();

    void save(JSONObject jSONObject);
}
