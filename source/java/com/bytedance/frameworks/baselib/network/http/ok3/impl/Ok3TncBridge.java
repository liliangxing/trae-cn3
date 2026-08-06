package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface Ok3TncBridge {
    JSONObject getTNCInfo();

    void onOk3Response(Request request, Response response);

    void onOk3Timeout(Request request, Exception exc);
}
