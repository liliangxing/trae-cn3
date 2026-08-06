package com.bytedance.lynx.service.network;

import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;

/* loaded from: classes4.dex */
public interface LynxHttpInterceptor {
    HttpResponse interceptRequest(HttpRequest httpRequest);

    void onRequest(HttpRequest httpRequest);

    void onResponse(HttpRequest httpRequest, HttpResponse httpResponse);
}
