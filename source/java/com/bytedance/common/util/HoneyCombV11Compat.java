package com.bytedance.common.util;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class HoneyCombV11Compat {
    static Method sMethodWebViewOnPause;
    static Method sMethodWebViewOnResume;
    static boolean sWebViewPauseResumeGot;

    /* loaded from: classes3.dex */
    static class HoneyCombImpl {
        HoneyCombImpl() {
        }

        public static Context getContext(AlertDialog.Builder builder) {
            return builder.getContext();
        }

        public static int getLargeMemoryClass(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }

        public static void setDisplayZoomControl(WebSettings webSettings, boolean z) {
            webSettings.setDisplayZoomControls(z);
        }

        public static void pauseWebView(WebView webView) {
            webView.onPause();
        }

        public static void resumeWebView(WebView webView) {
            webView.onResume();
        }
    }

    public static Context getContext(Context context, AlertDialog.Builder builder) {
        return HoneyCombImpl.getContext(builder);
    }

    public static void setDisplayZoomControl(WebSettings webSettings, boolean z) {
        HoneyCombImpl.setDisplayZoomControl(webSettings, z);
    }

    public static void pauseWebView(WebView webView) {
        if (webView == null) {
            return;
        }
        HoneyCombImpl.pauseWebView(webView);
    }

    public static void resumeWebView(WebView webView) {
        if (webView == null) {
            return;
        }
        HoneyCombImpl.resumeWebView(webView);
    }

    private static void tryGetWebViewPauseResumeMethod() {
        if (sWebViewPauseResumeGot) {
            return;
        }
        sWebViewPauseResumeGot = true;
        try {
            sMethodWebViewOnPause = WebView.class.getMethod(WebViewContainer.EVENT_onPause, null);
            sMethodWebViewOnResume = WebView.class.getMethod("onResume", null);
        } catch (Exception unused) {
        }
    }

    public static int getLargeMemoryClass(ActivityManager activityManager) {
        try {
            return HoneyCombImpl.getLargeMemoryClass(activityManager);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
