package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import com.bytedance.android.monitorV2.webview.gecko.IHybridMonitorGeckoClient;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebViewMonitorHelperImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001pB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0012\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u001eJ0\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u0001000\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u000100`\u000e2\u0006\u0010'\u001a\u00020\u001eH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0006H\u0002J;\u00104\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020$2!\u00106\u001a\u001d\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001a07H\u0016J\u0010\u0010<\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001f\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010?2\u0006\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010B\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u000108H\u0016J\u0018\u0010F\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020HH\u0016J6\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u00062\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000200\u0018\u00010NH\u0016J\u0018\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002J\u0010\u0010R\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010S\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010T\u001a\b\u0012\u0002\b\u0003\u0018\u00010U2\u0006\u0010V\u001a\u00020\u0006H\u0002J\u0010\u0010W\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010X\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010Y\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u0018\u0010Z\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u0018\u0010[\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010\\\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020$H\u0016J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010_\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J#\u0010`\u001a\u00020\u001a2\u0016\u0010a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060?\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010bJ\u0018\u0010c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020eH\u0016J0\u0010f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u0006H\u0016J\u0010\u0010k\u001a\u00020\u001a2\b\u0010l\u001a\u0004\u0018\u00010\bJ*\u0010m\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020D2\u0006\u0010n\u001a\u00020$2\b\u0010o\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\n0\n0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00180\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewMonitorHelperImpl;", "Lcom/bytedance/android/monitorV2/webview/IMonitorHelperNew;", "()V", "DELAY_LOAD", "", "TAG", "", "geckoClient", "Lcom/bytedance/android/monitorV2/webview/gecko/IHybridMonitorGeckoClient;", "isNeedMonitorOldTmp", "", "mWebViewClasses", "Ljava/util/HashMap;", "Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;", "Lkotlin/collections/HashMap;", "mWebViewMissClasses", "Ljava/util/HashSet;", "mWebViewObjs", "mainHandler", "Landroid/os/Handler;", "webViewHookMap", "Ljava/util/concurrent/ConcurrentHashMap;", "kotlin.jvm.PlatformType", "webViewManagerMap", "Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;", "addConfig", "", "config", "addContext", "webView", "Landroid/webkit/WebView;", Api.KEY_ENCRYPT_RESP_KEY, "value", "addExtraEventInfo", "type", "state", "", "copyConfig", "createWebViewKey", "view", "customReport", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "forceReport", "reportEvent", "getConfig", "Lcom/bytedance/android/monitorV2/webview/WebViewMonitorHelperImpl$ConfigObj;", "getExtraInfo", "", "getGeckoSlardarJs", "getIsNeedMonitor", "json", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "getWebViewClass", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getWebViewManager", "handleNativeInfo", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "jsonObject", "handleRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "handleSPPMonitorInfo", "eventType", "engineHash", "url", "params", "", "isAssignedFrom", "compareA", "compareB", "isNeedMonitor", "isTTWebHookSuccess", "loadClass", "Ljava/lang/Class;", "clazzName", "onAttachedToWindow", "onGoBack", "onLoadUrl", "onPageFinished", "onPageStarted", "onProgressChanged", "newProgress", "onWebViewCreated", "onWebViewDestroyed", "removeConfig", "webViewClassesNames", "([Ljava/lang/String;)V", "reportFallbackPage", "fallBackInfo", "Lcom/bytedance/android/monitorV2/entity/FallBackInfo;", "reportGeckoInfo", "resStatus", "resType", "resUrl", "resVersion", "setGeckoClient", "client", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "ConfigObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewMonitorHelperImpl implements IMonitorHelperNew {
    private IHybridMonitorGeckoClient geckoClient;
    private boolean isNeedMonitorOldTmp;
    private final String TAG = "WebViewMonitorHelperImp";
    private final HashMap<String, IWebViewMonitorHelper.Config> mWebViewClasses = new HashMap<>();
    private final HashMap<String, IWebViewMonitorHelper.Config> mWebViewObjs = new HashMap<>();
    private final HashSet<String> mWebViewMissClasses = new HashSet<>();
    private final long DELAY_LOAD = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<String, WebViewDataManager> webViewManagerMap = new ConcurrentHashMap<>(new HashMap());
    private final ConcurrentHashMap<String, Boolean> webViewHookMap = new ConcurrentHashMap<>(new WeakHashMap());

    private final WebViewDataManager getWebViewManager(WebView webView) {
        String createWebViewKey = createWebViewKey(webView);
        WebViewDataManager webViewDataManager = this.webViewManagerMap.get(createWebViewKey);
        if (webViewDataManager != null) {
            return webViewDataManager;
        }
        WebViewDataManager webViewDataManager2 = new WebViewDataManager(new WeakReference(webView), this);
        WebViewDataManager putIfAbsent = this.webViewManagerMap.putIfAbsent(createWebViewKey, webViewDataManager2);
        return putIfAbsent == null ? webViewDataManager2 : putIfAbsent;
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onWebViewCreated(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).onViewCreate();
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onAttachedToWindow(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).onAttachedToWindow();
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onLoadUrl(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        getWebViewManager(webView).onLoadUrl(url);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onPageStarted(WebView webView, CommonEvent event) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(event, "event");
        getWebViewManager(webView).onPageStarted(event);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onPageFinished(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        getWebViewManager(webView).onPageFinished(url);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onProgressChanged(WebView webView, int newProgress) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).onProgressChanged(newProgress);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).onGoBack();
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void onWebViewDestroyed(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).onDestroy();
        String createWebViewKey = createWebViewKey(webView);
        this.webViewManagerMap.remove(createWebViewKey);
        this.webViewHookMap.remove(createWebViewKey);
        this.mWebViewObjs.remove(createWebViewKey);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(detail, "detail");
        getWebViewManager(webView).handleRenderProcessGone(detail);
        this.webViewManagerMap.remove(createWebViewKey(webView));
        this.webViewHookMap.remove(createWebViewKey(webView));
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void customReport(WebView webView, CustomEvent customEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        getWebViewManager(webView).customReport(customEvent);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void addContext(WebView webView, String key, String value) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        getWebViewManager(webView).addContext(key, value);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void reportGeckoInfo(WebView webView, String resStatus, String resType, String resUrl, String resVersion) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(resStatus, "resStatus");
        Intrinsics.checkNotNullParameter(resType, "resType");
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        Intrinsics.checkNotNullParameter(resVersion, "resVersion");
        getWebViewManager(webView).reportGeckoInfo(resStatus, resType, resUrl, resVersion);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void reportFallbackPage(WebView webView, FallBackInfo fallBackInfo) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(fallBackInfo, "fallBackInfo");
        getWebViewManager(webView).reportFallbackPage(fallBackInfo);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void addExtraEventInfo(WebView webView, String type, int state) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        getWebViewManager(webView).addExtraEventInfo(type, state);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void forceReport(WebView webView, String reportEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(reportEvent, "reportEvent");
        getWebViewManager(webView).forceReport(reportEvent);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void handleNativeInfo(WebView webView, CommonEvent event, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(event, "event");
        getWebViewManager(webView).handleNativeInfo(event, jsonObject);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void getPerformance(WebView webView, int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        getWebViewManager(webView).getPerformance(waitCompleteData, performanceCallback);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public EngineInfo getUnifyInfo(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return getWebViewManager(webView).getUnifyInfo();
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void updateUnifyError(WebView webView, CommonEvent event, int code, String message) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(event, "event");
        getWebViewManager(webView).updateUnifyError(event, code, message);
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public void handleSPPMonitorInfo(String eventType, String engineHash, String url, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(engineHash, "engineHash");
        Intrinsics.checkNotNullParameter(url, "url");
        WebViewDataManager webViewDataManager = this.webViewManagerMap.get(engineHash);
        if (webViewDataManager != null) {
            webViewDataManager.handleSPPMonitorInfo(eventType, url, params);
        }
    }

    public final void setGeckoClient(IHybridMonitorGeckoClient client) {
        if (client != null) {
            this.geckoClient = client;
        }
        this.mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorHelperImpl$setGeckoClient$1
            @Override // java.lang.Runnable
            public final void run() {
                IHybridMonitorGeckoClient iHybridMonitorGeckoClient;
                iHybridMonitorGeckoClient = WebViewMonitorHelperImpl.this.geckoClient;
                if (iHybridMonitorGeckoClient != null) {
                    iHybridMonitorGeckoClient.checkAndInit();
                }
            }
        }, this.DELAY_LOAD);
    }

    private final String createWebViewKey(WebView view) {
        return view == null ? "" : view.hashCode() + "";
    }

    public final boolean isNeedMonitor(WebView view) {
        boolean z;
        try {
            IWebViewMonitorHelper.Config config = getConfig(view).getConfig();
            z = config != null ? config.mIsNeedMonitor : true;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            z = false;
        }
        if (this.isNeedMonitorOldTmp != z) {
            MonitorLog.m29i(this.TAG, "isNeedMonitor: " + z);
            this.isNeedMonitorOldTmp = z;
        }
        return z;
    }

    public final boolean isTTWebHookSuccess(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        String createWebViewKey = createWebViewKey(webView);
        if (!this.webViewHookMap.containsKey(createWebViewKey)) {
            this.webViewHookMap.put(createWebViewKey, Boolean.valueOf(TTUtils.INSTANCE.getTTWebHookState(webView)));
        }
        Boolean bool = this.webViewHookMap.get(createWebViewKey);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final ConfigObj getConfig(WebView view) {
        IWebViewMonitorHelper.Config config;
        if (view == null) {
            return new ConfigObj("view is null", null);
        }
        String createWebViewKey = createWebViewKey(view);
        String name = view.getClass().getName();
        IWebViewMonitorHelper.Config config2 = this.mWebViewObjs.get(createWebViewKey);
        if (config2 != null) {
            return new ConfigObj("mWebViewObjs:" + createWebViewKey + " viewClass:" + name, config2);
        }
        IWebViewMonitorHelper.Config config3 = this.mWebViewClasses.get(name);
        if (config3 != null) {
            return new ConfigObj("mWebViewClasses:" + name, config3);
        }
        if (this.mWebViewMissClasses.contains(name)) {
            return new ConfigObj("webViewClazz in mWebViewMissClasses", null);
        }
        for (String str : new HashSet(this.mWebViewClasses.keySet())) {
            Intrinsics.checkNotNullExpressionValue(name, "webViewClazz");
            if (isAssignedFrom(name, str) && (config = this.mWebViewClasses.get(str)) != null) {
                this.mWebViewClasses.put(name, config);
                return new ConfigObj(name + " isAssignedFrom:" + str, config);
            }
        }
        this.mWebViewMissClasses.add(name);
        return new ConfigObj("objects classes superclass all miss", null);
    }

    private final boolean isAssignedFrom(String compareA, String compareB) {
        Class<?> loadClass = loadClass(compareA);
        Class<?> loadClass2 = loadClass(compareB);
        if (loadClass == null || loadClass2 == null) {
            return false;
        }
        return loadClass2.isAssignableFrom(loadClass);
    }

    private final Class<?> loadClass(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return null;
        }
    }

    private final boolean getIsNeedMonitor(String json) {
        return JsonUtils.safeOptBool(JsonUtils.safeToJsonOb(json), "webview_is_need_monitor", false);
    }

    private final String[] getWebViewClass(String json) {
        JSONArray safeOptJsonArray;
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(json) || (safeOptJsonArray = JsonUtils.safeOptJsonArray(JsonUtils.safeToJsonOb(json), "webview_classes")) == null) {
            return strArr;
        }
        String[] strArr2 = new String[safeOptJsonArray.length()];
        int length = safeOptJsonArray.length();
        for (int i = 0; i < length; i++) {
            try {
                strArr2[i] = safeOptJsonArray.getString(i);
            } catch (JSONException unused) {
            }
        }
        return strArr2;
    }

    @Override // com.bytedance.android.monitorV2.webview.IMonitorHelperNew
    public HashMap<String, Object> getExtraInfo(WebView view) {
        WebNativeCommon webNativeCommon;
        Intrinsics.checkNotNullParameter(view, "view");
        Pair[] pairArr = new Pair[1];
        NavigationDataManager currentNavigation = getWebViewManager(view).getCurrentNavigation();
        pairArr[0] = TuplesKt.to("navigation_id", (currentNavigation == null || (webNativeCommon = currentNavigation.getWebNativeCommon()) == null) ? null : webNativeCommon.navigationId);
        return MapsKt.hashMapOf(pairArr);
    }

    public final void addConfig(IWebViewMonitorHelper.Config config) {
        if (config == null) {
            return;
        }
        try {
            IWebViewMonitorHelper.Config copyConfig = copyConfig(config);
            String[] strArr = copyConfig.mWebViewObjKeys;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    HashMap<String, IWebViewMonitorHelper.Config> hashMap = this.mWebViewObjs;
                    Intrinsics.checkNotNullExpressionValue(str, "objKey");
                    hashMap.put(str, copyConfig);
                }
            }
            String[] strArr2 = copyConfig.mWebViewClasses;
            if (strArr2 != null && strArr2.length != 0) {
                for (String str2 : strArr2) {
                    this.mWebViewClasses.put(str2, copyConfig);
                }
            }
            this.mWebViewMissClasses.clear();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private final IWebViewMonitorHelper.Config copyConfig(IWebViewMonitorHelper.Config config) {
        String[] webViewClass;
        boolean isNeedMonitor;
        IWebViewMonitorHelper.Config config2 = new IWebViewMonitorHelper.Config();
        config.setBid(config.mBid);
        config2.virtualAid = config.virtualAid;
        config2.mSlardarSDKPath = getGeckoSlardarJs();
        config2.mIsNeedMonitor = config.mIsNeedMonitor;
        config2.sourceMonitor = config.sourceMonitor;
        config2.mWebViewObjKeys = config.mWebViewObjKeys;
        config2.mWebViewClasses = config.mWebViewClasses;
        config2.mBid = config.mBid;
        config2.mWebBlankCallback = config.mWebBlankCallback;
        config2.mSlardarSDKConfig = TextUtils.isEmpty(config.mSlardarSDKConfig) ? WebViewMonitorConfig.buildDefaultConfig() : config.mSlardarSDKConfig;
        config2.mContext = config.mContext;
        config2.fallbackContainerName = config.fallbackContainerName;
        config2.mIsNeedInjectBrowser = config.mIsNeedInjectBrowser;
        config2.mSessionId = config.mSessionId;
        if (!TextUtils.isEmpty(config.mSettingConfig)) {
            JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(config.mSettingConfig);
            if (JsonUtils.safeOptObj(safeToJsonOb, "webview_classes") == null) {
                webViewClass = config2.mWebViewClasses;
            } else {
                String str = config.mSettingConfig;
                Intrinsics.checkNotNullExpressionValue(str, "config.mSettingConfig");
                webViewClass = getWebViewClass(str);
            }
            config2.mWebViewClasses = webViewClass;
            if (JsonUtils.safeOptObj(safeToJsonOb, "webview_is_need_monitor") == null) {
                isNeedMonitor = config2.mIsNeedMonitor;
            } else {
                String str2 = config.mSettingConfig;
                Intrinsics.checkNotNullExpressionValue(str2, "config.mSettingConfig");
                isNeedMonitor = getIsNeedMonitor(str2);
            }
            config2.mIsNeedMonitor = isNeedMonitor;
            config2.mSlardarSDKConfig = TextUtils.isEmpty(config.mSettingConfig) ? config2.mSlardarSDKConfig : new WebViewMonitorConfig(config.mSettingConfig).buildConfig();
        }
        return config2;
    }

    private final String getGeckoSlardarJs() {
        if (this.geckoClient != null) {
            try {
                StringBuilder sb = new StringBuilder();
                IHybridMonitorGeckoClient iHybridMonitorGeckoClient = this.geckoClient;
                Intrinsics.checkNotNull(iHybridMonitorGeckoClient);
                File file = new File(sb.append(iHybridMonitorGeckoClient.getResourcePath()).append("/slardar.js").toString());
                if (file.exists()) {
                    return file.getAbsolutePath();
                }
            } catch (Exception e) {
                ExceptionUtil.handleException(e);
            }
        }
        return null;
    }

    /* compiled from: WebViewMonitorHelperImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewMonitorHelperImpl$ConfigObj;", "", DBHelper.BATTERY_COL_SOURCE, "", "config", "Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;", "(Ljava/lang/String;Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;)V", "getConfig", "()Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;", "setConfig", "(Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;)V", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class ConfigObj {
        private IWebViewMonitorHelper.Config config;
        private String source;

        public static /* synthetic */ ConfigObj copy$default(ConfigObj configObj, String str, IWebViewMonitorHelper.Config config, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configObj.source;
            }
            if ((i & 2) != 0) {
                config = configObj.config;
            }
            return configObj.copy(str, config);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* renamed from: component2, reason: from getter */
        public final IWebViewMonitorHelper.Config getConfig() {
            return this.config;
        }

        public final ConfigObj copy(String source, IWebViewMonitorHelper.Config config) {
            return new ConfigObj(source, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigObj)) {
                return false;
            }
            ConfigObj configObj = (ConfigObj) other;
            return Intrinsics.areEqual(this.source, configObj.source) && Intrinsics.areEqual(this.config, configObj.config);
        }

        public int hashCode() {
            String str = this.source;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            IWebViewMonitorHelper.Config config = this.config;
            return hashCode + (config != null ? config.hashCode() : 0);
        }

        public ConfigObj(String str, IWebViewMonitorHelper.Config config) {
            this.source = str;
            this.config = config;
        }

        public final IWebViewMonitorHelper.Config getConfig() {
            return this.config;
        }

        public final String getSource() {
            return this.source;
        }

        public final void setConfig(IWebViewMonitorHelper.Config config) {
            this.config = config;
        }

        public final void setSource(String str) {
            this.source = str;
        }

        public String toString() {
            return "ConfigObj(source=" + this.source + ", config=" + this.config + ')';
        }
    }

    public final void removeConfig(String... webViewClassesNames) {
        Intrinsics.checkNotNullParameter(webViewClassesNames, "webViewClassesNames");
        for (String str : webViewClassesNames) {
            HashMap<String, IWebViewMonitorHelper.Config> hashMap = this.mWebViewClasses;
            if (hashMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            TypeIntrinsics.asMutableMap(hashMap).remove(str);
        }
    }
}
