package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3TTPSandBoxInterceptor implements Interceptor {
    private static volatile ITncSandBox sSandBox;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ITncSandBox {
        boolean isTncRequestProceed(String str, String str2, Map<String, List<String>> map, String str3);
    }

    public static void setTncSandbox(ITncSandBox iTncSandBox) {
        sSandBox = iTncSandBox;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (sSandBox != null && "/get_domains/v5/".equals(request.url().encodedPath()) && !sSandBox.isTncRequestProceed(request.method(), request.url().toString(), request.headers().toMultimap(), "")) {
            throw new IOException("TNC requsest dropped by sandbox");
        }
        return chain.proceed(request);
    }
}
