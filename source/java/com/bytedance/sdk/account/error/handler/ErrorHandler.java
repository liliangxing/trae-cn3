package com.bytedance.sdk.account.error.handler;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface ErrorHandler {

    /* loaded from: classes5.dex */
    public interface HandlerCallback {
        void onHandlerResult(boolean z, boolean z2, Map<String, String> map);

        void onHandlerResult(boolean z, boolean z2, Map<String, String> map, BaseApiResponse baseApiResponse);
    }

    String getName();

    boolean handle(int i, Map<String, String> map, JSONObject jSONObject, HandlerCallback handlerCallback);
}
