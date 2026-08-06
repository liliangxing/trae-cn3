package com.bytedance.android.monitor.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.android.monitor.base.BuildConfig;
import com.bytedance.android.monitor.entity.CustomInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.android.monitor.util.JsonUtils;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebViewMonitorJsBridge {
    private WeakReference<WebView> mWebViewRef;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @JavascriptInterface
    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public WebViewMonitorJsBridge(WebView webView) {
        this.mWebViewRef = new WeakReference<>(webView);
    }

    @JavascriptInterface
    public void cover(final String str, final String str2) {
        if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor(this.mWebViewRef.get())) {
            MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TTLiveWebViewMonitorHelper.getInnerInstance().cover((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), JsonUtils.safeOptStr(JsonUtils.safeToJsonOb(str), "url"), str2, str);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void reportDirectly(final String str, final String str2) {
        if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor(this.mWebViewRef.get())) {
            MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TTLiveWebViewMonitorHelper.getInnerInstance().reportDirectly((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), str2, str);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void batch(final String str) {
        if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor(this.mWebViewRef.get())) {
            MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONArray jSONArray = new JSONArray(str);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String jSONObject2 = jSONObject.toString();
                            String safeOptStr = JsonUtils.safeOptStr(jSONObject, "serviceType");
                            if (safeOptStr.equals("")) {
                                JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jSONObject, "category"));
                                TTLiveWebViewMonitorHelper.getInstance().customReport((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), new CustomInfo.Builder(JsonUtils.safeOptStr(jSONObject, "eventName")).setCategory(safeToJsonOb).setExtra(JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jSONObject, "extra"))).setTiming(JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jSONObject, "timing"))).setMetric(JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jSONObject, "metrics"))).setEnableSample(JsonUtils.safeOptBool(jSONObject, "canSample", true)).build());
                            } else if (!safeOptStr.equals("perf")) {
                                TTLiveWebViewMonitorHelper.getInnerInstance().reportDirectly((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), safeOptStr, jSONObject2);
                            } else {
                                TTLiveWebViewMonitorHelper.getInnerInstance().cover((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), JsonUtils.safeOptStr(jSONObject, "url"), safeOptStr, jSONObject2);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void customReport(final String str, final String str2, final String str3, final boolean z, final String str4, final String str5) {
        if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor(this.mWebViewRef.get()) && !TextUtils.isEmpty(str)) {
            MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str3);
                        JSONObject safeToJsonOb2 = JsonUtils.safeToJsonOb(str2);
                        JSONObject safeToJsonOb3 = JsonUtils.safeToJsonOb(str4);
                        TTLiveWebViewMonitorHelper.getInstance().customReport((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), new CustomInfo.Builder(str).setCategory(safeToJsonOb).setMetric(safeToJsonOb2).setExtra(safeToJsonOb3).setTiming(JsonUtils.safeToJsonOb(str5)).setEnableSample(z).build());
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void sendInitTimeInfo(final String str) {
        if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor(this.mWebViewRef.get())) {
            MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.5
                @Override // java.lang.Runnable
                public void run() {
                    TTLiveWebViewMonitorHelper.getInnerInstance().initTime((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), str);
                }
            });
        }
    }

    @JavascriptInterface
    public void reportPageLatestData(final String str) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.6
            @Override // java.lang.Runnable
            public void run() {
                if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get())) {
                    final JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
                    String safeOptStr = JsonUtils.safeOptStr(safeToJsonOb, "performance");
                    String safeOptStr2 = JsonUtils.safeOptStr(JsonUtils.safeToJsonOb(safeOptStr), "serviceType");
                    String safeOptStr3 = JsonUtils.safeOptStr(safeToJsonOb, "resource");
                    String safeOptStr4 = JsonUtils.safeOptStr(JsonUtils.safeToJsonOb(safeOptStr3), "serviceType");
                    final String safeOptStr5 = JsonUtils.safeOptStr(safeToJsonOb, "url");
                    TTLiveWebViewMonitorHelper.getInnerInstance().cover((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), safeOptStr5, safeOptStr2, safeOptStr);
                    TTLiveWebViewMonitorHelper.getInnerInstance().reportDirectly((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), safeOptStr4, safeOptStr3);
                    WebViewMonitorJsBridge.this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                MonitorLog.m6d("TTLiveWebViewMonitorJsBridge", "reportPageLatestData : " + safeOptStr5);
                                String safeOptStr6 = JsonUtils.safeOptStr(safeToJsonOb, "needReport");
                                if (TextUtils.isEmpty(safeOptStr6) || !safeOptStr6.equals("true")) {
                                    return;
                                }
                                TTLiveWebViewMonitorHelper.getInstance().reportTruly((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get());
                            } catch (Throwable th) {
                                ExceptionUtil.handleException(th);
                            }
                        }
                    });
                }
            }
        });
    }

    @JavascriptInterface
    public void injectJS() {
        final long currentTimeMillis = System.currentTimeMillis();
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebViewMonitorJsBridge.7
            @Override // java.lang.Runnable
            public void run() {
                if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedMonitor((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get())) {
                    TTLiveWebViewMonitorHelper.getInnerInstance().injectJS((WebView) WebViewMonitorJsBridge.this.mWebViewRef.get(), currentTimeMillis);
                }
            }
        });
    }
}
