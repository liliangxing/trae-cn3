package com.bytedance.android.monitor.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitor.entity.JSBError;
import com.bytedance.android.monitor.entity.JSBInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWebExtension {
    void forceReport(WebView webView, String str);

    void forceReport(WebView webView, String str, IWebBlankCallback iWebBlankCallback);

    void handleFetchSuccess(WebView webView);

    void handleJSBError(WebView webView, JSBError jSBError);

    void handleJSBInfo(WebView webView, JSBInfo jSBInfo);

    void reportABTestData(WebView webView, long j);

    void reportEvent(WebView webView, String str, int i);

    void saveData(WebView webView, String str, String str2, JSONObject jSONObject);

    void saveData(WebView webView, String str, JSONObject jSONObject);
}
