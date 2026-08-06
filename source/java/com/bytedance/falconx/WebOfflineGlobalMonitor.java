package com.bytedance.falconx;

import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;

/* loaded from: classes3.dex */
public class WebOfflineGlobalMonitor {
    private static IGlobalMonitor sGlobalMonitor;

    /* loaded from: classes3.dex */
    public interface IGlobalMonitor {
        void onInterceptRequest(WebView webView, InterceptorModel interceptorModel, boolean z);
    }

    public static void setGlobalMonitor(IGlobalMonitor iGlobalMonitor) {
        sGlobalMonitor = iGlobalMonitor;
    }

    public static void onInterceptRequest(WebView webView, InterceptorModel interceptorModel, boolean z) {
        IGlobalMonitor iGlobalMonitor = sGlobalMonitor;
        if (iGlobalMonitor != null) {
            iGlobalMonitor.onInterceptRequest(webView, interceptorModel, z);
        }
    }
}
