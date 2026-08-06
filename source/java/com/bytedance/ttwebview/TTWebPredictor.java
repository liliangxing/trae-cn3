package com.bytedance.ttwebview;

import android.net.Uri;
import com.bytedance.forest.interceptor.ForestMonitor;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.lynx.webview.TTWebSdk;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* compiled from: TTWebPredictor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ttwebview/TTWebPredictor;", "", "()V", "DEDICATED_URL_PATH", "", "TAG", "URL_QUERY_KEY_TTWEB_PRECONNECT_HOSTS", "hasInitPreload", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initResPreload", "", "isWebviewUrl", "", "url", "Landroid/net/Uri;", "preconnect", "schemaUri", "preconnectInternel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TTWebPredictor {
    public static final TTWebPredictor INSTANCE = new TTWebPredictor();
    private static final String TAG = "TTWebPredictor";
    private static final String URL_QUERY_KEY_TTWEB_PRECONNECT_HOSTS = "ttweb_preconnect_hosts";
    private static final String DEDICATED_URL_PATH = "/magic/eco/runtime/release";
    private static AtomicBoolean hasInitPreload = new AtomicBoolean(false);

    private TTWebPredictor() {
    }

    public final void initResPreload() {
        Object obj;
        if (hasInitPreload.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isSuccess-impl(obj)) {
                ForestMonitor forestMonitor = new ForestMonitor() { // from class: com.bytedance.ttwebview.TTWebPredictor$initResPreload$2$ttWebInterceptor$1
                    public void onLoadStart(String url, RequestParams requestParams) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
                    }

                    public void onLoadFinished(Response response) {
                        String str;
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.getRequest().isWebRequest()) {
                            try {
                                if (!TTWebSdk.isTTWebView()) {
                                    GlobalInterceptor.INSTANCE.unregisterMonitor(this);
                                    HybridLogger hybridLogger = HybridLogger.INSTANCE;
                                    str5 = TTWebPredictor.TAG;
                                    HybridLogger.e$default(hybridLogger, str5, "[PREDICTOR_DEBUG] ttwebview  not init or use sys webview, unregister ttWebInterceptor from forest", null, null, 12, null);
                                    return;
                                }
                                if (!TTWebSdk.isFeatureSupport("predictor", 0)) {
                                    GlobalInterceptor.INSTANCE.unregisterMonitor(this);
                                    HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                                    str4 = TTWebPredictor.TAG;
                                    HybridLogger.e$default(hybridLogger2, str4, "[PREDICTOR_DEBUG] ttwebview not support predictor for version 0, unregister ttWebInterceptor from forest", null, null, 12, null);
                                    return;
                                }
                                if (response.getRequest().isPreload() && response.isSucceed() && response.getVersion() != 0) {
                                    String url = response.getRequest().getUrl();
                                    byte[] provideBytes = response.provideBytes();
                                    if (provideBytes == null) {
                                        HybridLogger hybridLogger3 = HybridLogger.INSTANCE;
                                        str3 = TTWebPredictor.TAG;
                                        HybridLogger.e$default(hybridLogger3, str3, "[PREDICTOR_DEBUG] ttwebview preload failed for no bytes from preload response " + url, null, null, 12, null);
                                    } else {
                                        if (TTWebSdk.preloadResource(url, provideBytes, "{\"x-ttwebview-response-update-time\":\"" + response.getVersion() + "\",\"isMainResource\":" + (response.getRequest().getScene() == Scene.WEB_MAIN_DOCUMENT) + '}')) {
                                            return;
                                        }
                                        HybridLogger hybridLogger4 = HybridLogger.INSTANCE;
                                        str2 = TTWebPredictor.TAG;
                                        HybridLogger.e$default(hybridLogger4, str2, "[PREDICTOR_DEBUG] ttwebview preload failed for size: " + provideBytes.length + StringListParam.SPLIT_DELIMITER + url, null, null, 12, null);
                                    }
                                }
                            } catch (Exception e) {
                                HybridLogger hybridLogger5 = HybridLogger.INSTANCE;
                                str = TTWebPredictor.TAG;
                                HybridLogger.e$default(hybridLogger5, str, "onLoadFinished and try ttweb preload but error with " + e.getMessage(), null, null, 12, null);
                            }
                        }
                    }
                };
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "GlobalInterceptor.registerMonitor(ttWebInterceptor)", null, null, 12, null);
                GlobalInterceptor.INSTANCE.registerMonitor(forestMonitor);
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "no ttwebview sdk loaded into app", null, null, 12, null);
            }
        }
    }

    public final void preconnect(Uri schemaUri) {
        Object obj;
        Intrinsics.checkNotNullParameter(schemaUri, "schemaUri");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            try {
                Uri parse = Uri.parse(schemaUri.getQueryParameter("url"));
                TTWebPredictor tTWebPredictor = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(parse, "urlInSchema");
                if (tTWebPredictor.isWebviewUrl(parse)) {
                    tTWebPredictor.preconnectInternel(parse);
                }
            } catch (Exception e) {
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "ttweb preconnect error " + e.getMessage(), null, null, 12, null);
            }
        }
    }

    private final boolean isWebviewUrl(Uri url) {
        String scheme = url.getScheme();
        if (scheme != null) {
            return StringsKt.startsWith$default(scheme, "http", false, 2, (Object) null);
        }
        return false;
    }

    private final void preconnectInternel(Uri url) {
        ArrayList<String> arrayList = new ArrayList();
        String path = url.getPath();
        if (path != null) {
            if (!((url.getScheme() == null || url.getHost() == null || !StringsKt.startsWith$default(path, DEDICATED_URL_PATH, false, 2, (Object) null)) ? false : true)) {
                path = null;
            }
            if (path != null) {
                arrayList.add(url.getScheme() + "://" + url.getHost());
            }
        }
        try {
            String queryParameter = url.getQueryParameter(URL_QUERY_KEY_TTWEB_PRECONNECT_HOSTS);
            if (queryParameter != null) {
                JSONArray jSONArray = new JSONArray(queryParameter);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(i)");
                    arrayList.add(string);
                }
            }
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "parse query error, " + e.getMessage(), null, null, 12, null);
        }
        for (String str : arrayList) {
            TTWebSdk.preconnectUrl(str, 1);
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "ttweb preconnect " + str, null, null, 12, null);
        }
    }
}
