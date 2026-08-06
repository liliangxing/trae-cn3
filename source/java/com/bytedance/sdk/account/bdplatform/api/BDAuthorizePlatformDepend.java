package com.bytedance.sdk.account.bdplatform.api;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface BDAuthorizePlatformDepend {
    String authHost();

    int checkRequestException(Throwable th);

    void execute(Runnable runnable);

    String executeGet(String str) throws Exception;

    String executePost(String str, Map<String, String> map) throws Exception;

    boolean isNetworkEnable();

    void onLogEvent(String str, JSONObject jSONObject);

    String ticketHost();
}
