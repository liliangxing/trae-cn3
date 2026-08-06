package com.bytedance.trae.network;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: IntranetProber.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/network/IntranetProber;", "", "<init>", "()V", "TAG", "", "PING_URLS", "", "getPING_URLS", "()Ljava/util/List;", "DEFAULT_TIMEOUT_MS", "", "isReachable", "", "url", "timeoutMs", "getRegionalPingUrl", "isRegionalReachable", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IntranetProber {
    private static final int DEFAULT_TIMEOUT_MS = 2000;
    public static final IntranetProber INSTANCE = new IntranetProber();
    private static final List<String> PING_URLS = CollectionsKt.listOf(new String[]{"https://icube-api.bytedance.net/trae/ping", "https://icube-api-sg.tiktok-row.net/trae/ping"});
    private static final String TAG = "IntranetProber";

    private IntranetProber() {
    }

    public final List<String> getPING_URLS() {
        return PING_URLS;
    }

    public static /* synthetic */ boolean isReachable$default(IntranetProber intranetProber, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = PING_URLS.get(0);
        }
        if ((i2 & 2) != 0) {
            i = DEFAULT_TIMEOUT_MS;
        }
        return intranetProber.isReachable(str, i);
    }

    public final boolean isReachable(String url, int timeoutMs) {
        HttpURLConnection httpURLConnection;
        Intrinsics.checkNotNullParameter(url, "url");
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                URLConnection openConnection = new URL(url).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(timeoutMs);
            httpURLConnection.setReadTimeout(timeoutMs);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Accept", "application/json");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                FLogger.INSTANCE.mo428i(TAG, "探测失败: " + url + " HTTP " + responseCode);
                httpURLConnection.disconnect();
                return false;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                JSONObject jSONObject = new JSONObject(readText);
                boolean z = jSONObject.optBoolean("success", false) && Intrinsics.areEqual(jSONObject.optString("data", ""), "TRAE");
                FLogger.INSTANCE.mo428i(TAG, "探测: " + url + " → " + z);
                httpURLConnection.disconnect();
                return z;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(bufferedReader, th2);
                    throw th3;
                }
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = httpURLConnection;
            FLogger.INSTANCE.mo428i(TAG, "探测异常: " + url + ' ' + e.getMessage());
            if (httpURLConnection2 == null) {
                return false;
            }
            httpURLConnection2.disconnect();
            return false;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public final String getRegionalPingUrl() {
        List<String> list;
        int i;
        if (AppHost.Companion.isOversea()) {
            list = PING_URLS;
            i = 1;
        } else {
            list = PING_URLS;
            i = 0;
        }
        return list.get(i);
    }

    public static /* synthetic */ boolean isRegionalReachable$default(IntranetProber intranetProber, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_TIMEOUT_MS;
        }
        return intranetProber.isRegionalReachable(i);
    }

    public final boolean isRegionalReachable(int timeoutMs) {
        return isReachable(getRegionalPingUrl(), timeoutMs);
    }
}
