package com.bytedance.tobshadow.applog;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IPickerCallback {
    void failed(String str);

    void success(JSONObject jSONObject);
}
