package com.bytedance.bdturing;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface BdTuringCallback {
    void onFail(int i, JSONObject jSONObject);

    void onSuccess(int i, JSONObject jSONObject);
}
