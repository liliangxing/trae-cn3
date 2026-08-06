package com.bytedance.ies.web.jsbridge;

import android.webkit.WebView;
import com.bytedance.tobshadow.applog.util.WebViewJsUtil;

/* loaded from: classes4.dex */
public class LoadUrlUtil {
    static final BaseImpl IMPL = new KitKatImpl();

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    private static class KitKatImpl extends BaseImpl {
        private KitKatImpl() {
            super();
        }

        @Override // com.bytedance.ies.web.jsbridge.LoadUrlUtil.BaseImpl
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
