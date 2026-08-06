package com.bytedance.ies.web.jsbridge;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IJavaMethod {
    void call(JsMsg jsMsg, JSONObject jSONObject) throws Exception;
}
