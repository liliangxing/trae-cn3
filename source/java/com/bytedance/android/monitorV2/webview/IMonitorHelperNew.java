package com.bytedance.android.monitorV2.webview;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: IMonitorHelperNew.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J0\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00142\u0006\u0010\u0015\u001a\u00020\u0005H&J;\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\f2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00030\u0019H&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001aH&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H&J6\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H&J\u0018\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H&J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00103\u001a\u00020\fH&J\u0010\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u000208H&J0\u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H&J*\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010\u0007H&¨\u0006A"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/IMonitorHelperNew;", "", "addContext", "", "webView", "Landroid/webkit/WebView;", Api.KEY_ENCRYPT_RESP_KEY, "", "value", "addExtraEventInfo", "type", "state", "", "customReport", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "forceReport", "reportEvent", "getExtraInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "view", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "handleNativeInfo", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "jsonObject", "handleRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "handleSPPMonitorInfo", "eventType", "engineHash", "url", "params", "", "onAttachedToWindow", "onGoBack", "onLoadUrl", "onPageFinished", "onPageStarted", "onProgressChanged", "newProgress", "onWebViewCreated", "onWebViewDestroyed", "reportFallbackPage", "fallBackInfo", "Lcom/bytedance/android/monitorV2/entity/FallBackInfo;", "reportGeckoInfo", "resStatus", "resType", "resUrl", "resVersion", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IMonitorHelperNew {
    void addContext(WebView webView, String key, String value);

    void addExtraEventInfo(WebView webView, String type, int state);

    void customReport(WebView webView, CustomEvent customEvent);

    void forceReport(WebView webView, String reportEvent);

    HashMap<String, Object> getExtraInfo(WebView view);

    void getPerformance(WebView webView, int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback);

    EngineInfo getUnifyInfo(WebView webView);

    void handleNativeInfo(WebView webView, CommonEvent event, JSONObject jsonObject);

    void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail detail);

    void handleSPPMonitorInfo(String eventType, String engineHash, String url, Map<String, ? extends Object> params);

    void onAttachedToWindow(WebView webView);

    void onGoBack(WebView webView);

    void onLoadUrl(WebView webView, String url);

    void onPageFinished(WebView webView, String url);

    void onPageStarted(WebView webView, CommonEvent event);

    void onProgressChanged(WebView webView, int newProgress);

    void onWebViewCreated(WebView webView);

    void onWebViewDestroyed(WebView webView);

    void reportFallbackPage(WebView webView, FallBackInfo fallBackInfo);

    void reportGeckoInfo(WebView webView, String resStatus, String resType, String resUrl, String resVersion);

    void updateUnifyError(WebView webView, CommonEvent event, int code, String message);
}
