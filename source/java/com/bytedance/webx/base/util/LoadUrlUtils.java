package com.bytedance.webx.base.util;

import android.webkit.WebView;
import com.bytedance.tobshadow.applog.util.WebViewJsUtil;

/* loaded from: classes6.dex */
public class LoadUrlUtils {
    static final BaseImpl IMPL = new KitKatImpl();

    /* loaded from: classes6.dex */
    private static class BaseImpl {
        private BaseImpl() {
        }

        public void loadUrl(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class KitKatImpl extends BaseImpl {
        private KitKatImpl() {
            super();
        }

        @Override // com.bytedance.webx.base.util.LoadUrlUtils.BaseImpl
        public void loadUrl(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith(WebViewJsUtil.JS_URL_PREFIX)) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void loadUrl(WebView webView, String str) {
        IMPL.loadUrl(webView, str);
    }
}
