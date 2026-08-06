package com.bytedance.ies.web.jsbridge;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IProtectedFuncHandler {
    boolean needUpdateConfig(JsMsg jsMsg);

    void updateProtectedFunc(JsMsg jsMsg, JSONObject jSONObject, String str, IOnProtectedUpdateListener iOnProtectedUpdateListener);
}
