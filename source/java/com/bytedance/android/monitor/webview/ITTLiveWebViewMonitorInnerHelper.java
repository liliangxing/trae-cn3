package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import com.bytedance.android.monitor.base.IMonitor;
import com.bytedance.android.monitor.webview.base.ITTWebviewDetect;
import com.bytedance.android.monitor.webview.base.IWebBlankCallback;

/* loaded from: classes3.dex */
public interface ITTLiveWebViewMonitorInnerHelper {
    void cover(WebView webView, String str, String str2, String str3);

    String getBiz(WebView webView);

    IWebBlankCallback getBlankDetectCallback(WebView webView);

    ITTLiveWebViewMonitorCustomCallback getCustomCallback(WebView webView);

    IMonitor getMonitor(WebView webView);

    ITTWebviewDetect getTTWebviewDetect(WebView webView);

    String getVirtualAid(WebView webView);

    void initTime(WebView webView, String str);

    void injectJS(WebView webView, long j);

    boolean isNeedAutoReport(WebView webView);

    boolean isNeedMonitor(WebView webView);

    boolean isWebviewDestoryed(WebView webView);

    void onViewAttach(WebView webView);

    void onViewDetach(WebView webView);

    void reportDirectly(WebView webView, String str, String str2);
}
