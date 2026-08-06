package com.bytedance.ug.sdk.share.api.depend;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IShareNetworkConfig {
    int checkResponseException(Throwable th);

    String executeGet(int i, String str) throws Exception;

    String executePost(int i, String str, JSONObject jSONObject) throws Exception;

    String getHost();
}
