package com.bytedance.trae.anniex;

import android.content.SharedPreferences;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.cn.auth.ILocalStorage;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.platform.service.ApplogService;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: AnnieXInitializer.kt */
@Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JB\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0018\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R#\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"com/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "provideLocalStorage", "Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;", "provideBuiltInPermissionConfig", "", "provideCacheConfigPermissionCapacity", "", "provideGeckoAccessKey", "provideRemoteConfigUrl", "provideAppId", "provideAppVersion", "provideDeviceId", "provideNamespaces", "", "provideWorkerExecutor", "Ljava/util/concurrent/Executor;", "doRequestRemoteConfigAsync", "", "runnable", "Ljava/lang/Runnable;", "doPost", IWeixinService.ResponseConstants.URL, "headers", "", "contentType", "body", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AnnieXInitializer$initAnnieX$1 implements IPermissionConfigProvider {

    /* renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.anniex.AnnieXInitializer$initAnnieX$1$$ExternalSyntheticLambda0
        public final Object invoke() {
            SharedPreferences prefs_delegate$lambda$0;
            prefs_delegate$lambda$0 = AnnieXInitializer$initAnnieX$1.prefs_delegate$lambda$0();
            return prefs_delegate$lambda$0;
        }
    });

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String provideBuiltInPermissionConfig() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public int provideCacheConfigPermissionCapacity() {
        return 50;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String provideGeckoAccessKey() {
        return "2373bbcf94c1b893dad48961d0a2d086";
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String provideRemoteConfigUrl() {
        return "https://gecko.snssdk.com/gecko/v2/jsb_permission";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences prefs_delegate$lambda$0() {
        return AppHost.INSTANCE.getApplication().getSharedPreferences("bdx_bridge_permission", 0);
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public ILocalStorage provideLocalStorage() {
        return new ILocalStorage() { // from class: com.bytedance.trae.anniex.AnnieXInitializer$initAnnieX$1$provideLocalStorage$1
            @Override // com.bytedance.sdk.xbridge.cn.auth.ILocalStorage
            public String read(String key) {
                SharedPreferences prefs;
                Intrinsics.checkNotNullParameter(key, "key");
                prefs = AnnieXInitializer$initAnnieX$1.this.getPrefs();
                return prefs.getString(key, null);
            }

            @Override // com.bytedance.sdk.xbridge.cn.auth.ILocalStorage
            public JSONObject readObject(String key) {
                SharedPreferences prefs;
                Intrinsics.checkNotNullParameter(key, "key");
                prefs = AnnieXInitializer$initAnnieX$1.this.getPrefs();
                String string = prefs.getString(key, null);
                if (string == null) {
                    return null;
                }
                try {
                    return new JSONObject(string);
                } catch (Exception unused) {
                    return null;
                }
            }

            @Override // com.bytedance.sdk.xbridge.cn.auth.ILocalStorage
            public void write(String key, String value) {
                SharedPreferences prefs;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                prefs = AnnieXInitializer$initAnnieX$1.this.getPrefs();
                prefs.edit().putString(key, value).apply();
            }

            @Override // com.bytedance.sdk.xbridge.cn.auth.ILocalStorage
            public void writeObject(String key, JSONObject value) {
                SharedPreferences prefs;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                prefs = AnnieXInitializer$initAnnieX$1.this.getPrefs();
                prefs.edit().putString(key, value.toString()).apply();
            }
        };
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public int provideAppId() {
        return AppHost.INSTANCE.getAppId();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String provideAppVersion() {
        return AppHost.INSTANCE.getVersionName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String provideDeviceId() {
        return ApplogService.INSTANCE.getDeviceId();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public List<String> provideNamespaces() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public Executor provideWorkerExecutor() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        return newSingleThreadExecutor;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public void doRequestRemoteConfigAsync(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Executors.newSingleThreadExecutor().execute(runnable);
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider
    public String doPost(String url, Map<String, String> headers, String contentType, byte[] body) {
        BufferedReader bufferedReader;
        String str = url;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(OpenNetMethod.POST);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && value != null) {
                        httpURLConnection.setRequestProperty(key, value);
                    }
                }
            }
            if (contentType != null) {
                httpURLConnection.setRequestProperty("Content-Type", contentType);
            }
            if (body != null) {
                bufferedReader = httpURLConnection.getOutputStream();
                try {
                    bufferedReader.write(body);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            }
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, FConstants.DOWNLOAD_BUFFER_SIZE);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                return readText;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
