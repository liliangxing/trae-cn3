package com.bytedance.android.monitorV2.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.FallBackInfo;

/* loaded from: classes3.dex */
public interface IBusinessCustom {
    @Deprecated
    void addContext(WebView webView, String str, Object obj);

    void addContext(WebView webView, String str, String str2);

    void reportFallbackPage(WebView webView, FallBackInfo fallBackInfo);

    void reportGeckoInfo(WebView webView, String str, String str2, String str3);

    void reportGeckoInfo(WebView webView, String str, String str2, String str3, String str4);
}
