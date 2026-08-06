package com.bytedance.android.monitorV2.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;

/* loaded from: classes3.dex */
public interface IDeprecated {
    @Deprecated
    void initConfig(IWebViewMonitorHelper.Config config);

    @Deprecated
    void onClientOffline(WebView webView, String str, boolean z);

    @Deprecated
    void onOffline(WebView webView, String str, boolean z);
}
