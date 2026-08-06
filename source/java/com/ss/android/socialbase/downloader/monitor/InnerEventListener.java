package com.ss.android.socialbase.downloader.monitor;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface InnerEventListener {
    void onEvent(int i, String str, JSONObject jSONObject);

    void onUnityEvent(int i, String str, JSONObject jSONObject);
}
