package com.facebook.net;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3CookieInterceptor;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoOkHttpClient {
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    public static final String TAG = "FrescoOkHttpClient";
    private static OkHttpClient sOkClient;

    public static OkHttpClient getIns() {
        synchronized (FrescoOkHttpClient.class) {
            OkHttpClient okHttpClient = sOkClient;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new OkHttp3CookieInterceptor());
            builder.networkInterceptors().add(new Interceptor() { // from class: com.facebook.net.FrescoOkHttpClient.1
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    try {
                        Connection connection = chain.connection();
                        Route route = connection != null ? connection.route() : null;
                        r2 = route != null ? route.socketAddress() : null;
                        if (Logger.debug()) {
                            Logger.d(FrescoOkHttpClient.TAG, "-call- get res -  req: " + request.hashCode() + " conn: " + connection + " route: " + route + " addr: " + r2);
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        Response proceed = chain.proceed(request);
                        if (r2 == null) {
                            return proceed;
                        }
                        try {
                            Response.Builder newBuilder = proceed.newBuilder();
                            newBuilder.addHeader("x-snssdk.remoteaddr", r2.getAddress().getHostAddress());
                            return newBuilder.build();
                        } catch (Throwable unused2) {
                            return proceed;
                        }
                    } catch (IOException e) {
                        if (r2 != null) {
                            try {
                                String message = e.getMessage();
                                StringBuilder sb = new StringBuilder();
                                StringBuilder append = sb.append(r2.getAddress().getHostAddress()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                if (message == null) {
                                    message = "null";
                                }
                                append.append(message);
                                Reflect.on(e).set("detailMessage", sb.toString());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            });
            OkHttpClient build = builder.build();
            sOkClient = build;
            return build;
        }
    }
}
