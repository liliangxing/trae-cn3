package com.bytedance.sdk.account.platform.api;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IAuthorizeMonitorService extends IAuthorizeService {
    void onEvent(String str, JSONObject jSONObject);
}
