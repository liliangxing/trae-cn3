package com.bytedance.android.monitor.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitor.entity.CustomInfo;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWebCustom {

    /* loaded from: classes3.dex */
    public interface IContextCallback {
        Map<String, Object> onMonitor(WebView webView, String str);
    }

    void customReport(WebView webView, CustomInfo customInfo);

    @Deprecated
    void customReport(WebView webView, String str, String str2, String str3, String str4);

    @Deprecated
    void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6);

    void customReport(WebView webView, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z);

    void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z);

    void rejectReportCallback(WebView webView, IContextCallback iContextCallback);
}
