package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3Builder {
    private static final int FRAMED_APPLYED = 4;
    private static final int FRAMED_NO_ALL = 3;
    private static final int FRAMED_NO_H2 = 2;
    private static final int FRAMED_NO_SPDY = 1;
    public static final String TAG = "OkHttp3Builder";
    private static int sDisableFramedTransport;
    private static IOkHttpClientBuilderHook sOkHttpClientBuilderHook;
    private Ok3TncBridge mOk3TncBridge;
    private OkHttpClient mOkClient;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface IOkHttpClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder builder);
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    public static void setOkHttpClientBuilderHook(IOkHttpClientBuilderHook iOkHttpClientBuilderHook) {
        sOkHttpClientBuilderHook = iOkHttpClientBuilderHook;
    }

    public void setOk3TncBridge(Ok3TncBridge ok3TncBridge) {
        this.mOk3TncBridge = ok3TncBridge;
    }

    public static void disableFramedTransport(int i) {
        if (i <= 0 || sDisableFramedTransport != 0) {
            return;
        }
        sDisableFramedTransport = i;
    }

    private static OkHttpClient checkDisableFramedTransport(OkHttpClient okHttpClient) {
        int i = sDisableFramedTransport;
        if (i <= 0 || i >= 4 || okHttpClient == null) {
            return okHttpClient;
        }
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        setProtocols(newBuilder);
        return newBuilder.build();
    }

    private static void setProtocols(OkHttpClient.Builder builder) {
        if (builder == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = sDisableFramedTransport;
        if (i == 1) {
            arrayList.add(Protocol.HTTP_2);
        } else if (i == 2) {
            arrayList.add(Protocol.SPDY_3);
        } else if (i != 3) {
            arrayList.add(Protocol.HTTP_2);
            arrayList.add(Protocol.SPDY_3);
        }
        sDisableFramedTransport = 4;
        arrayList.add(Protocol.HTTP_1_1);
        builder.protocols(Collections.unmodifiableList(arrayList));
    }

    public OkHttpClient build() {
        return build(true);
    }

    public OkHttpClient build(boolean z) {
        if (z) {
            NetworkParams.tryNecessaryInit();
        }
        synchronized (NetworkParams.class) {
            OkHttpClient okHttpClient = this.mOkClient;
            if (okHttpClient != null) {
                checkDisableFramedTransport(okHttpClient);
                return this.mOkClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            int i = sDisableFramedTransport;
            if (i > 0 && i < 4) {
                setProtocols(builder);
            }
            builder.connectionPool(new ConnectionPool(15, 180000L, TimeUnit.MILLISECONDS));
            builder.connectTimeout(NetworkParams.getConnectTimeout(), TimeUnit.MILLISECONDS);
            builder.readTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);
            builder.writeTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);
            builder.addNetworkInterceptor(new Interceptor() { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3Builder.1
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    try {
                        Connection connection = chain.connection();
                        Route route = connection != null ? connection.route() : null;
                        r2 = route != null ? route.socketAddress() : null;
                        if (Logger.debug()) {
                            Logger.d(OkHttp3Builder.TAG, "-call- get res -  req: " + request.hashCode() + " conn: " + connection + " route: " + route + " addr: " + r2);
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
                            newBuilder.addHeader(NetworkParams.PNAME_REMOTE_ADDRESS, r2.getAddress().getHostAddress());
                            return newBuilder.build();
                        } catch (Throwable unused2) {
                            return proceed;
                        }
                    } catch (IOException e) {
                        if (r2 != null) {
                            try {
                                String message = e.getMessage();
                                StringBuilder sb = new StringBuilder();
                                StringBuilder append = sb.append(r2.getAddress().getHostAddress()).append("|");
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
            builder.ttnetDns(OkHttp3DnsParserInterceptor.inst());
            builder.cookieJar(CookieJar.NO_COOKIES);
            builder.addNetworkInterceptor(new OkHttp3CookieInterceptor());
            builder.addInterceptor(new OkHttp3SecurityFactorInterceptor());
            builder.addInterceptor(new OkHttp3TTPSandBoxInterceptor());
            builder.addNetworkInterceptor(new OkHttp3PureControlInterceptor());
            OkHttpClient.Builder enableTls12OnPreLollipop = enableTls12OnPreLollipop(builder);
            enableTls12OnPreLollipop.followRedirects(true);
            IOkHttpClientBuilderHook iOkHttpClientBuilderHook = sOkHttpClientBuilderHook;
            if (iOkHttpClientBuilderHook != null) {
                iOkHttpClientBuilderHook.addBuilderConfig(enableTls12OnPreLollipop);
            }
            OkHttpClient build = enableTls12OnPreLollipop.build();
            this.mOkClient = build;
            return build;
        }
    }

    private static OkHttpClient.Builder enableTls12WithTwoParamsMethod(OkHttpClient.Builder builder, SSLContext sSLContext) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                builder.sslSocketFactory(new Tls12SocketFactory(sSLContext.getSocketFactory()), (X509TrustManager) trustManager);
                return builder;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
    }
}
