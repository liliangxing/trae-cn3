package com.bytedance.crash;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IAnrUploadCallback {
    void onCrash(long j, long j2, String str, JSONObject jSONObject);
}
