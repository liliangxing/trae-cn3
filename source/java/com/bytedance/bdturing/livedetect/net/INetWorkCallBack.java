package com.bytedance.bdturing.livedetect.net;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface INetWorkCallBack {
    void onError(Throwable th);

    void onResponse(int i, JSONObject jSONObject, String... strArr);
}
