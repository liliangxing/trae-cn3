package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.C1302e;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebViewSSLCheckThread extends Thread {

    /* renamed from: i */
    private static final String f2147i = "WebViewSSLCheckThread";

    /* renamed from: a */
    private SSLSocketFactory f2148a;

    /* renamed from: b */
    private HostnameVerifier f2149b;

    /* renamed from: c */
    private org.apache.http.conn.ssl.SSLSocketFactory f2150c;

    /* renamed from: d */
    private X509HostnameVerifier f2151d;

    /* renamed from: e */
    private SslErrorHandler f2152e;

    /* renamed from: f */
    private String f2153f;

    /* renamed from: g */
    private Callback f2154g;

    /* renamed from: h */
    private Context f2155h;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C1292a implements okhttp3.Callback {

        /* renamed from: a */
        final /* synthetic */ Callback f2156a;

        /* renamed from: b */
        final /* synthetic */ Context f2157b;

        /* renamed from: c */
        final /* synthetic */ String f2158c;

        /* renamed from: d */
        final /* synthetic */ SslErrorHandler f2159d;

        C1292a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f2156a = callback;
            this.f2157b = context;
            this.f2158c = str;
            this.f2159d = sslErrorHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            C1302e.m2407b(WebViewSSLCheckThread.f2147i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f2156a;
            if (callback != null) {
                callback.onCancel(this.f2157b, this.f2158c);
            } else {
                this.f2159d.cancel();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            C1302e.m2407b(WebViewSSLCheckThread.f2147i, "onResponse . proceed");
            Callback callback = this.f2156a;
            if (callback != null) {
                callback.onProceed(this.f2157b, this.f2158c);
            } else {
                this.f2159d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    /* renamed from: b */
    private void m2342b() throws Exception {
        this.f2150c.setHostnameVerifier(this.f2151d);
        org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.f2150c;
        if (sSLSocketFactory instanceof SecureApacheSSLSocketFactory) {
            ((SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.f2155h);
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("https", this.f2150c, 443));
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(this.f2153f));
        C1302e.m2408c(f2147i, "status code is : " + defaultHttpClient.execute(httpGet).getStatusLine().getStatusCode());
    }

    /* renamed from: c */
    private void m2343c() {
        String str = f2147i;
        C1302e.m2408c(str, "callbackCancel: ");
        Callback callback = this.f2154g;
        if (callback != null) {
            callback.onCancel(this.f2155h, this.f2153f);
        } else if (this.f2152e != null) {
            C1302e.m2408c(str, "callbackCancel 2: ");
            this.f2152e.cancel();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    /* renamed from: d */
    private void m2344d() {
        C1302e.m2408c(f2147i, "callbackProceed: ");
        Callback callback = this.f2154g;
        if (callback != null) {
            callback.onProceed(this.f2155h, this.f2153f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f2152e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    /* renamed from: e */
    private void m2345e() throws IOException {
        HttpsURLConnection httpsURLConnection;
        Throwable th;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URLConnection openConnection = new URL(this.f2153f).openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                httpsURLConnection = (HttpsURLConnection) openConnection;
                try {
                    httpsURLConnection.setSSLSocketFactory(this.f2148a);
                    httpsURLConnection.setHostnameVerifier(this.f2149b);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(20000);
                    httpsURLConnection.connect();
                    httpsURLConnection2 = httpsURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
        } catch (Throwable th3) {
            httpsURLConnection = null;
            th = th3;
        }
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f2151d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f2150c;
    }

    public Callback getCallback() {
        return this.f2154g;
    }

    public Context getContext() {
        return this.f2155h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f2149b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f2152e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f2148a;
    }

    public String getUrl() {
        return this.f2153f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.f2150c != null && this.f2151d != null) {
            if (this.f2152e != null && !TextUtils.isEmpty(this.f2153f)) {
                try {
                    m2342b();
                    m2344d();
                    return;
                } catch (Exception e) {
                    C1302e.m2407b(f2147i, "run: exception : " + e.getMessage());
                    m2343c();
                    return;
                }
            }
            C1302e.m2407b(f2147i, "sslErrorHandler or url is null");
            m2343c();
            return;
        }
        if (this.f2148a != null && this.f2149b != null) {
            try {
                m2345e();
                m2344d();
                return;
            } catch (Exception e2) {
                C1302e.m2407b(f2147i, "exception : " + e2.getMessage());
                m2343c();
                return;
            }
        }
        m2343c();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f2151d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f2150c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f2154g = callback;
    }

    public void setContext(Context context) {
        this.f2155h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f2149b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f2152e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f2148a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f2153f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new C1295c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new C1295c(context)));
        } catch (UnrecoverableKeyException e) {
            C1302e.m2407b(f2147i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler != null && !TextUtils.isEmpty(str) && context != null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new C1295c(context));
                secureSSLSocketFactoryNew.setContext(context);
                builder.sslSocketFactory(secureSSLSocketFactoryNew, new C1295c(context));
                builder.hostnameVerifier(new StrictHostnameVerifier());
                builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new C1292a(callback, context, str, sslErrorHandler));
                return;
            } catch (Exception e) {
                C1302e.m2407b(f2147i, "checkServerCertificateWithOK: exception : " + e.getMessage());
                sslErrorHandler.cancel();
                return;
            }
        }
        C1302e.m2407b(f2147i, "checkServerCertificateWithOK: handler or url or context is null");
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f2152e = sslErrorHandler;
        this.f2153f = str;
        this.f2150c = sSLSocketFactory;
        this.f2151d = x509HostnameVerifier;
        this.f2154g = callback;
        this.f2155h = context;
    }
}
