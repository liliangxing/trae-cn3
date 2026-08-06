package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.webkit.ProxyConfig;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Locale;
import okhttp3.OkHttpClient;
import okhttp3.internal.Version;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SsOkHttp3Client extends BaseHttpClient {
    public static final int FALL_BACK_REASON_BOOT = 3;
    public static final int FALL_BACK_REASON_CRONET_EXCEPTION = 7;
    public static final int FALL_BACK_REASON_CRONET_EXCEPTION_ONCE = 10;
    public static final int FALL_BACK_REASON_DEFAULT = -1;
    public static final int FALL_BACK_REASON_FORCE = 0;
    public static final int FALL_BACK_REASON_MODEL = 8;
    public static final int FALL_BACK_REASON_NO_PLUGIN = 6;
    public static final int FALL_BACK_REASON_NULL_APPCONFIG = 9;
    public static final int FALL_BACK_REASON_X86 = 2;
    public static final String OK3_VERSION = "tt-ok/3.12.13.2-rc.2";
    public static final String TAG = "SsOkHttp3Client";
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static Context sContext = null;
    private static volatile String sDefaultUA = "";
    private static volatile String sFallbackMessage = "";
    private static volatile int sFallbackReason = -1;
    private static volatile SsOkHttp3Client sInstance = null;
    private static volatile boolean sNotAllowUseNetwork = false;
    private static Ok3TncBridge sOk3TncBridge = null;
    private static OkHttp3Builder sOkHttp3Builder = null;
    private static volatile IOkHttpAppInfoProvider sOkHttpAppInfoProvider = null;
    private static String sOkVersion = "tt-ok/3.10.0.2";
    private static volatile Proxy sProxy;
    private static int sVersionCode;
    private static final Object sVersionCodeLock = new Object();

    public static SsOkHttp3Client inst(Context context) {
        if (sInstance == null) {
            synchronized (SsOkHttp3Client.class) {
                if (sInstance == null) {
                    sInstance = new SsOkHttp3Client(context);
                }
            }
        }
        return sInstance;
    }

    private SsOkHttp3Client(Context context) {
        String str;
        String str2;
        try {
            str = Version.userAgent();
        } catch (Throwable unused) {
            str = null;
            try {
                Field declaredField = Class.forName("okhttp3.internal.Util").getDeclaredField("userAgent");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("okhttp/")) {
                str2 = str.replaceFirst("okhttp/", "tt-ok/");
            } else {
                str2 = "tt-ok/" + str;
            }
            sOkVersion = str2;
        }
        sContext = context.getApplicationContext();
        sOkHttp3Builder = new OkHttp3Builder();
        URLDispatcher.inst().loadLocalConfig(sContext);
        HttpDns.getService().setHttpDnsDepend(new IHttpDnsDepend() { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client.1
            @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
            public Context getContext() {
                return SsOkHttp3Client.sContext;
            }

            @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
            public String[] getPreloadDomains() {
                if (SsOkHttp3Client.sOkHttpAppInfoProvider != null) {
                    return SsOkHttp3Client.sOkHttpAppInfoProvider.getHttpDnsPreloadDomains();
                }
                return null;
            }

            @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
            public String getAppId() {
                if (SsOkHttp3Client.sOkHttpAppInfoProvider != null) {
                    return String.valueOf(SsOkHttp3Client.sOkHttpAppInfoProvider.getAid());
                }
                return null;
            }

            @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
            public String getHttpDnsDomain() {
                if (SsOkHttp3Client.sOkHttpAppInfoProvider != null) {
                    return SsOkHttp3Client.sOkHttpAppInfoProvider.getHttpDnsDomain();
                }
                return null;
            }

            @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
            public String[] getHardCodeIps() {
                if (SsOkHttp3Client.sOkHttpAppInfoProvider != null) {
                    return SsOkHttp3Client.sOkHttpAppInfoProvider.getHttpDnsDomainHardCodeIps();
                }
                return null;
            }
        });
    }

    public OkHttpClient getOkHttpClient() throws IllegalArgumentException {
        return getOkHttpClient(true);
    }

    public static OkHttpClient constructOkHttpClient() {
        return sOkHttp3Builder.build(false);
    }

    public OkHttpClient getOkHttpClient(boolean z) throws IllegalArgumentException {
        OkHttp3Builder okHttp3Builder = sOkHttp3Builder;
        if (okHttp3Builder == null) {
            throw new IllegalArgumentException("SsOkHttp3Client is not init !!!");
        }
        return okHttp3Builder.build(z);
    }

    public SsCall newSsCall(Request request) throws IOException {
        try {
            Request addStoreRegionHeaderForOkHttp = StoreRegionManager.inst().addStoreRegionHeaderForOkHttp(request);
            if (addStoreRegionHeaderForOkHttp != null) {
                request = addStoreRegionHeaderForOkHttp;
            }
        } catch (Throwable unused) {
        }
        Request filterQuery = QueryFilterEngine.inst().filterQuery(request);
        if (filterQuery != null) {
            request = filterQuery;
        }
        return new Ok3SsCall(request);
    }

    public static String getDefaultOkhttpUA() {
        if (TextUtils.isEmpty(sDefaultUA)) {
            StringBuilder sb = new StringBuilder();
            sb.append(sContext.getPackageName());
            sb.append('/');
            sb.append(versionFromContext(sContext));
            sb.append(" (Linux; U; Android ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("; ");
            sb.append(Locale.getDefault().toString());
            String str = Build.MODEL;
            if (str.length() > 0) {
                sb.append("; ");
                sb.append(str);
            }
            String str2 = Build.ID;
            if (str2.length() > 0) {
                sb.append("; Build/");
                sb.append(str2);
            }
            sb.append(";");
            sb.append(sOkVersion);
            sb.append(')');
            sDefaultUA = sb.toString();
        }
        return sDefaultUA;
    }

    private static int versionFromContext(Context context) {
        int i;
        synchronized (sVersionCodeLock) {
            if (sVersionCode == 0) {
                try {
                    sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            i = sVersionCode;
        }
        return i;
    }

    public void setOk3TncBridge(Ok3TncBridge ok3TncBridge) {
        sOk3TncBridge = ok3TncBridge;
    }

    public static Ok3TncBridge getOk3TncBridge() {
        return sOk3TncBridge;
    }

    public static void setNotAllowUseNetwork(boolean z) {
        sNotAllowUseNetwork = z;
    }

    public static boolean getNotAllowUseNetwork() {
        return sNotAllowUseNetwork;
    }

    public static void setFallbackReason(int i) {
        sFallbackReason = i;
    }

    public static int getFallbackReason() {
        return sFallbackReason;
    }

    public static void setFallbackMessage(String str) {
        sFallbackMessage = str;
    }

    public static String getFallbackMessage() {
        return sFallbackMessage;
    }

    public static void setProxy(String str) throws IllegalArgumentException {
        if (str == null) {
            sProxy = null;
            return;
        }
        String[] split = str.split(";");
        if (split.length <= 0) {
            throw new IllegalArgumentException("Invalid proxy rule:" + str);
        }
        String[] split2 = split[0].trim().split("=");
        if (split2.length != 2) {
            throw new IllegalArgumentException("Invalid proxy rule:" + str);
        }
        String lowerCase = split2[0].trim().toLowerCase();
        String[] split3 = split2[1].trim().split(":");
        if (split3.length != 2) {
            throw new IllegalArgumentException("Invalid proxy rule:" + str);
        }
        InetSocketAddress inetSocketAddress = new InetSocketAddress(split3[0], Integer.parseInt(split3[1]));
        if (lowerCase.equals("http") || lowerCase.equals(ProxyConfig.MATCH_HTTPS)) {
            sProxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        } else if (lowerCase.equals("socks") || lowerCase.equals("socks4") || lowerCase.equals("socks5")) {
            sProxy = new Proxy(Proxy.Type.SOCKS, inetSocketAddress);
        }
    }

    public static Proxy getProxy() {
        return sProxy;
    }

    public static void injectAppInfoProvider(IOkHttpAppInfoProvider iOkHttpAppInfoProvider) {
        sOkHttpAppInfoProvider = iOkHttpAppInfoProvider;
    }

    public static String getOkVersion() {
        return sOkVersion;
    }

    public static IOkHttpAppInfoProvider getOkHttpAppInfoProvider() {
        return sOkHttpAppInfoProvider;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getFallbackReasonHeaderValue(Request request) {
        if (request == null || request.getMetrics() == null) {
            return "null-metrics";
        }
        return "fallback_reason=" + sFallbackReason + ",fallback-message=" + Base64.encodeToString(sFallbackMessage.getBytes(), 2) + ",request-fallback-reason=" + request.getMetrics().requestFallbackReason + ",request-fallback-message=" + Base64.encodeToString(request.getMetrics().requestFallbackMessage.getBytes(), 2);
    }
}
