package com.bytedance.upc.common.network;

import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.upc.common.log.LogUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: UpcDefaultNetworkClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J<\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JN\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011\u0018\u00010\u00102\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/common/network/UpcDefaultNetworkClient;", "Lcom/bytedance/common/utility/NetworkClient;", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "get", "", "url", "requestHeaders", "", "ctx", "Lcom/bytedance/common/utility/NetworkClient$ReqContext;", "post", "data", "", "params", "", "Landroid/util/Pair;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcDefaultNetworkClient extends NetworkClient {
    private OkHttpClient okHttpClient;

    public String post(String url, byte[] data, Map<String, String> requestHeaders, NetworkClient.ReqContext ctx) {
        return "";
    }

    public UpcDefaultNetworkClient() {
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: com.bytedance.upc.common.network.UpcDefaultNetworkClient$okHttpClient$1
            public final Response intercept(Interceptor.Chain chain) {
                boolean z;
                Response response = null;
                int i = 3;
                do {
                    try {
                        response = chain.proceed(chain.request().newBuilder().addHeader("Content-type", "application/json").build());
                        z = false;
                    } catch (Throwable unused) {
                        z = true;
                    }
                    if (response != null && response.isSuccessful() && !z) {
                        break;
                    }
                    i--;
                } while (i > 0);
                return response != null ? response : new Response.Builder().build();
            }
        }).readTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).connectTimeout(15L, TimeUnit.SECONDS).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OkHttpClient.Builder().a…SECONDS)\n        .build()");
        this.okHttpClient = build;
    }

    public String get(String url, Map<String, String> requestHeaders, NetworkClient.ReqContext ctx) {
        try {
            Request.Builder url2 = new Request.Builder().url(url);
            if (requestHeaders != null) {
                for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                    url2.addHeader(entry.getKey(), entry.getValue());
                }
            }
            ResponseBody body = this.okHttpClient.newCall(url2.build()).execute().body();
            if (body == null) {
                return "";
            }
            String string = body.string();
            return string != null ? string : "";
        } catch (Throwable th) {
            LogUtils.m8e(th);
            return "";
        }
    }

    public String post(String url, List<Pair<String, String>> params, Map<String, String> requestHeaders, NetworkClient.ReqContext ctx) {
        try {
            Request.Builder post = new Request.Builder().url(url).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), String.valueOf(params)));
            Intrinsics.checkExpressionValueIsNotNull(post, "Request.Builder().url(ur…       .post(requestBody)");
            if (requestHeaders != null) {
                for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            ResponseBody body = this.okHttpClient.newCall(post.build()).execute().body();
            if (body == null) {
                return "";
            }
            String string = body.string();
            return string != null ? string : "";
        } catch (Throwable th) {
            LogUtils.m8e(th);
            return "";
        }
    }
}
