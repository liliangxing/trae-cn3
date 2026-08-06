package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import coil3.disk.DiskLruCache;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3SecurityFactorInterceptor implements Interceptor {
    private static final String KEY_BYPASS_MSSDK = "x-metasec-bypass-mssdk";
    private static final String KEY_OEC_OPAQUE_ENABLE = "x-tt-oec-opaque-enable";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (DiskLruCache.VERSION.equals(request.headers().get(KEY_BYPASS_MSSDK))) {
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.removeHeader(KEY_BYPASS_MSSDK);
            return chain.proceed(newBuilder.build());
        }
        Map<String, String> tryAddSecurityFactor = NetworkParams.tryAddSecurityFactor(request.url().toString(), request.headers().toMultimap());
        Map<String, String> tryAddOecSecurityFactor = DiskLruCache.VERSION.equals(request.headers().get(KEY_OEC_OPAQUE_ENABLE)) ? NetworkParams.tryAddOecSecurityFactor(request.url().toString(), request.headers().toMultimap()) : null;
        if (tryAddSecurityFactor == null && tryAddOecSecurityFactor == null) {
            return chain.proceed(request);
        }
        Request.Builder builder = new Request.Builder();
        builder.url(request.url());
        builder.method(request.method(), request.body());
        builder.tag(request.tag());
        Headers.Builder newBuilder2 = request.headers().newBuilder();
        if (tryAddSecurityFactor != null) {
            for (Map.Entry<String, String> entry : tryAddSecurityFactor.entrySet()) {
                newBuilder2.add(entry.getKey(), entry.getValue());
            }
        }
        if (tryAddOecSecurityFactor != null) {
            for (Map.Entry<String, String> entry2 : tryAddOecSecurityFactor.entrySet()) {
                newBuilder2.add(entry2.getKey(), entry2.getValue());
            }
        }
        newBuilder2.removeAll(KEY_OEC_OPAQUE_ENABLE);
        builder.headers(newBuilder2.build());
        return chain.proceed(builder.build());
    }
}
