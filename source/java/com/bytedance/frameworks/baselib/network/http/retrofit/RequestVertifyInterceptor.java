package com.bytedance.frameworks.baselib.network.http.retrofit;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RequestVertifyInterceptor implements TTInternalInterceptor {
    private Request interceptofend(Request request) {
        return (request == null || request.isResponseStreaming()) ? request : tryAddRequestVertifyParams(request);
    }

    private Request tryAddRequestVertifyParams(Request request) {
        try {
            String tryAddRequestVertifyParams = NetworkParams.tryAddRequestVertifyParams(request.getUrl(), request.isAddCommonParam(), request.getMetrics(), request.getBody());
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.url(tryAddRequestVertifyParams);
            return newBuilder.build();
        } catch (Throwable th) {
            th.printStackTrace();
            return request;
        }
    }

    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        Request interceptofend = interceptofend(chain.request());
        if (RealInterceptorChain.isProceedWithoutHookEnabled()) {
            return chain.proceedWithoutHook(interceptofend);
        }
        return chain.proceed(interceptofend);
    }
}
