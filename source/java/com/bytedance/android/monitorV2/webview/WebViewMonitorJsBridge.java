package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.ValidationReport;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.debug.MonitorDebugConfig;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.exception.HybridCrashHelper;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsConfigConvertUtils;
import com.bytedance.android.monitorV2.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebViewMonitorJsBridge {
    private static final String TAG = "WebViewMonitorJsBridge";
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private WebViewDataManager webViewDataManager;

    @JavascriptInterface
    public String getVersion() {
        return AnnieXMonitorConstants.ANNIEX_VERSION;
    }

    public WebViewMonitorJsBridge(WebViewDataManager webViewDataManager) {
        this.webViewDataManager = webViewDataManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationDataManager getNavigationManager() {
        return this.webViewDataManager.getCurrentNavigation();
    }

    @JavascriptInterface
    public void cover(final String str, final String str2) {
        MonitorLog.m29i(TAG, "cover: eventType: " + str2);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
                    JsonUtils.safeOptStr(safeToJsonOb, "url");
                    WebViewMonitorJsBridge.this.webViewDataManager.cover(safeToJsonOb, str2);
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
        });
    }

    @JavascriptInterface
    public void reportDirectly(final String str, final String str2) {
        MonitorLog.m29i(TAG, "reportDirectly: eventType: " + str2);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
                    NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                    if (navigationManager != null) {
                        navigationManager.postJsData(str2, safeToJsonOb);
                    }
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
        });
    }

    @JavascriptInterface
    public void batch(final String str) {
        MonitorLog.m29i(TAG, "batch: " + str);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        WebViewMonitorJsBridge.this.webViewDataManager.jsReport(jSONArray.getJSONObject(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @JavascriptInterface
    public void customReport(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
        int parseInt;
        MonitorLog.m29i(TAG, "customReport: event: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            parseInt = z ? 2 : 0;
        } else {
            parseInt = Integer.parseInt(str4);
        }
        try {
            JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str3);
            final CustomEvent customEvent = new CustomEvent(new CustomInfo.Builder(str).setCategory(safeToJsonOb).setMetric(JsonUtils.safeToJsonOb(str2)).setExtra(JsonUtils.safeToJsonOb(str5)).setTiming(JsonUtils.safeToJsonOb(str6)).setSample(parseInt).build());
            this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.4
                @Override // java.lang.Runnable
                public void run() {
                    NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                    if (navigationManager != null) {
                        navigationManager.postCustomEvent(customEvent);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @JavascriptInterface
    public void sendInitTimeInfo(final String str) {
        MonitorLog.m29i(TAG, "sendInitTimeInfo: " + str);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.5
            @Override // java.lang.Runnable
            public void run() {
                NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                if (navigationManager != null) {
                    navigationManager.updateMonitorInitTimeData(str);
                }
            }
        });
    }

    @JavascriptInterface
    public void reportPageLatestData(final String str) {
        MonitorLog.m29i(TAG, "report latest page data");
        HybridMonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
                final JSONObject safeToJsonOb2 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(safeToJsonOb, "performance"));
                final JSONObject safeToJsonOb3 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(safeToJsonOb, "resource"));
                final String safeOptStr = JsonUtils.safeOptStr(safeToJsonOb, "url");
                final JSONObject safeToJsonOb4 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(safeToJsonOb, "cacheData"));
                WebViewMonitorJsBridge.this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            MonitorLog.m26d(WebViewMonitorJsBridge.TAG, "reportPageLatestData : " + safeOptStr);
                            WebViewMonitorJsBridge.this.webViewDataManager.jsReport(safeToJsonOb2);
                            WebViewMonitorJsBridge.this.webViewDataManager.jsReport(safeToJsonOb3);
                            NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                            if (navigationManager != null) {
                                navigationManager.handlePageExit();
                            }
                            if (safeToJsonOb4.length() > 0) {
                                WebViewMonitorJsBridge.this.webViewDataManager.jsReport(safeToJsonOb4);
                            }
                        } catch (Throwable th) {
                            ExceptionUtil.handleException(th);
                        }
                    }
                });
            }
        });
    }

    @JavascriptInterface
    public void injectJS() {
        MonitorLog.m29i(TAG, "inject js");
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.7
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                if (navigationManager != null) {
                    navigationManager.markInjectJS(currentTimeMillis);
                }
            }
        });
    }

    @JavascriptInterface
    public void config(String str) {
        MonitorLog.m29i(TAG, "config: " + str);
        final JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
        final String safeOptStr = JsonUtils.safeOptStr(safeToJsonOb, "bid");
        final NavigationDataManager navigationManager = getNavigationManager();
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebViewMonitorJsBridge.lambda$config$0(NavigationDataManager.this, safeOptStr, safeToJsonOb);
            }
        });
        if (navigationManager == null || safeOptStr.isEmpty()) {
            return;
        }
        HybridCrashHelper.INSTANCE.bindInfo(navigationManager.getUrl(), safeOptStr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$config$0(NavigationDataManager navigationDataManager, String str, JSONObject jSONObject) {
        if (navigationDataManager != null) {
            if (navigationDataManager.getBid().isEmpty()) {
                navigationDataManager.setBid(str);
            }
            navigationDataManager.mergeJsConfig(JsConfigConvertUtils.INSTANCE.convert(jSONObject));
        }
    }

    @JavascriptInterface
    public void terminatedPreCollect(String str) {
        MonitorLog.m29i(TAG, "terminatedPreCollect: " + str);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.8
            @Override // java.lang.Runnable
            public void run() {
                NavigationDataManager navigationManager = WebViewMonitorJsBridge.this.getNavigationManager();
                if (navigationManager != null) {
                    navigationManager.getDataHandler().notifyAllEvents();
                }
            }
        });
    }

    @JavascriptInterface
    public String getInfo() {
        MonitorLog.m29i(TAG, "getInfo");
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, ReportConst.Params.NEED_REPORT, Boolean.valueOf(MonitorGlobalSp.getBooleanFromHDT(MonitorDebugConfig.SP_KEY_HDT_VALIDATION, false)));
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void reportVerifiedData(String str) {
        MonitorLog.m29i(TAG, "reportVerifiedData" + str);
        if (MonitorGlobalSp.getBooleanFromHDT(MonitorDebugConfig.SP_KEY_HDT_VALIDATION, false)) {
            ValidationReport.INSTANCE.validationReportForJS(JsonUtils.safeToJsonOb(str));
        }
    }

    @JavascriptInterface
    public void reportPiaInfo(final String str) {
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewMonitorJsBridge.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
                    WebViewMonitorHelper.getInstance().handlePiaInfo(WebViewMonitorJsBridge.this.webViewDataManager.getWebView(), JsonUtils.safeOptStr(safeToJsonOb, "type"), JsonUtils.safeOptJsonObj(safeToJsonOb, "category"), JsonUtils.safeOptJsonObj(safeToJsonOb, "metrics"));
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
        });
    }
}
