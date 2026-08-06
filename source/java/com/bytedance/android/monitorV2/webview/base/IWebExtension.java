package com.bytedance.android.monitorV2.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.JSBError;
import com.bytedance.android.monitorV2.entity.JSBInfo;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWebExtension {
    void forceReport(WebView webView, String str);

    void handleFetchSuccess(WebView webView);

    void handleJSBError(WebView webView, JSBError jSBError);

    void handleJSBInfo(WebView webView, JSBInfo jSBInfo);

    void handleJSBInfoV2(WebView webView, Map<String, Object> map);

    void handleJSBPvV2(WebView webView, Map<String, Object> map);

    void handleNativeInfo(WebView webView, String str, JSONObject jSONObject);

    void handlePiaInfo(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2);

    void handleSSPInfo(String str, String str2, String str3, Map<String, Object> map);

    void reportEvent(WebView webView, String str, int i);
}
