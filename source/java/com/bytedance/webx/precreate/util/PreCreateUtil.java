package com.bytedance.webx.precreate.util;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.bytedance.android.anniex.R;

/* loaded from: classes6.dex */
public class PreCreateUtil {
    public static void preloadChrome(Context context) {
        new WebView(context).destroy();
    }

    public static void destroyWebView(WebView webView, Context context) {
        if (webView != null) {
            webView.stopLoading();
            replaceContext(webView, context);
            webView.loadUrl("about:blank");
            webView.destroy();
        }
    }

    public static void replaceContext(WebView webView, Context context) {
        if (webView == null || context == null) {
            return;
        }
        Context context2 = webView.getContext();
        if (context2 instanceof MutableContextWrapper) {
            ((MutableContextWrapper) context2).setBaseContext(context);
        }
    }

    public static void markIsPreCreate(WebView webView, boolean z) {
        if (webView == null) {
            return;
        }
        webView.setTag(R.id.webx_precreate_is_precreate, Boolean.valueOf(z));
    }

    public static boolean isPreCreate(WebView webView) {
        if (webView == null) {
            return false;
        }
        Object tag = webView.getTag(R.id.webx_precreate_is_precreate);
        if (tag instanceof Boolean) {
            return ((Boolean) tag).booleanValue();
        }
        return false;
    }
}
