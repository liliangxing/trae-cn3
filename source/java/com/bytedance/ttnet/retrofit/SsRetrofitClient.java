package com.bytedance.ttnet.retrofit;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.HttpClient;
import java.io.IOException;

/* loaded from: classes4.dex */
public class SsRetrofitClient implements Client {
    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request request) throws IOException {
        IHttpClient httpClient = HttpClient.getHttpClient(request.getUrl(), request.getExtraInfo() instanceof BaseRequestContext ? ((BaseRequestContext) request.getExtraInfo()).force_use_okhttp : false);
        if (httpClient != null) {
            return httpClient.newSsCall(request);
        }
        return null;
    }
}
