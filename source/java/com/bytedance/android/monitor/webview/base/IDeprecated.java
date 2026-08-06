package com.bytedance.android.monitor.webview.base;

import android.webkit.WebView;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IDeprecated {
    @Deprecated
    String createWebViewKey(WebView webView);

    @Deprecated
    void customParams(WebView webView, String str);

    @Deprecated
    void customParseKey(WebView webView, Set<String> set);

    @Deprecated
    void initConfig(ITTLiveWebViewMonitorHelper.Config config);

    @Deprecated
    void onClientOffline(WebView webView, String str, boolean z);

    @Deprecated
    void onOffline(WebView webView, String str, boolean z);

    @Deprecated
    void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5);

    @Deprecated
    void removeWebViewKey(String str);
}
