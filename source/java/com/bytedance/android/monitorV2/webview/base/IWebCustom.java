package com.bytedance.android.monitorV2.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWebCustom {
    void customReport(WebView webView, CustomInfo customInfo);

    @Deprecated
    void customReport(WebView webView, String str, String str2, String str3, String str4);

    @Deprecated
    void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6);

    void customReport(WebView webView, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i);

    void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i);
}
