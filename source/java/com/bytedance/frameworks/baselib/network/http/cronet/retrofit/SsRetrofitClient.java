package com.bytedance.frameworks.baselib.network.http.cronet.retrofit;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.HttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SsRetrofitClient implements Client {
    private Context mContext;

    @Deprecated
    public SsRetrofitClient(Context context) {
        this.mContext = context;
    }

    public SsCall newSsCall(Request request) throws IOException {
        IHttpClient httpClient = HttpClient.getHttpClient(this.mContext, request.getUrl());
        if (httpClient != null) {
            return httpClient.newSsCall(request);
        }
        return null;
    }
}
