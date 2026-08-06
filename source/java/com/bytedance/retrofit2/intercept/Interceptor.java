package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;

/* loaded from: classes4.dex */
public interface Interceptor {

    /* loaded from: classes4.dex */
    public interface Chain {
        Call call();

        RetrofitMetrics metrics();

        SsResponse proceed(Request request) throws Exception;

        SsResponse proceedWithoutHook(Request request) throws Exception;

        Request request();
    }

    SsResponse intercept(Chain chain) throws Exception;
}
