package com.bytedance.common.util;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class LollipopV21Compat {
    private static BaseImpl mImpl = new LollipopImpl();

    /* loaded from: classes3.dex */
    private static class BaseImpl {
        public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        }

        public void setMixedContentMode(WebSettings webSettings, int i) {
        }

        private BaseImpl() {
        }
    }

    /* loaded from: classes3.dex */
    private static class LollipopImpl extends BaseImpl {
        private LollipopImpl() {
            super();
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setMixedContentMode(WebSettings webSettings, int i) {
            if (webSettings != null) {
                try {
                    webSettings.setMixedContentMode(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
            if (webView != null) {
                try {
                    CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setMixedContentMode(WebSettings webSettings, int i) {
        mImpl.setMixedContentMode(webSettings, i);
    }

    public static void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        mImpl.setAcceptThirdPartyCookies(webView, z);
    }
}
