package com.bytedance.crash;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface CrashUploadCallback {
    void beforeUpload(CrashType crashType, JSONObject jSONObject);
}
