package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.interceptor.AddHeaderInterceptor;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventFactory;
import okhttp3.OkHttpClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OkHttp3Instrumentation {
    public static OkHttpClient init() {
        return new OkHttpClient.Builder().addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(null)).build();
    }

    public static OkHttpClient build(OkHttpClient.Builder builder) {
        OkHttpClient build = builder.build();
        for (int size = builder.interceptors().size() - 1; size >= 0; size--) {
            if (builder.interceptors().get(size) instanceof AddHeaderInterceptor) {
                return build;
            }
        }
        return builder.addInterceptor(new AddHeaderInterceptor()).eventListenerFactory(new OkHttpEventFactory(build.eventListenerFactory())).build();
    }
}
