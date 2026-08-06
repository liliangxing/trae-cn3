package com.bytedance.ies.web.jsbridge2;

import android.view.View;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public abstract class AbsHybridViewLazy {
    private volatile boolean initialized = false;
    private volatile View hybridView = null;

    protected abstract View getViewOnce();

    public final View getHybridView() {
        if (!this.initialized) {
            synchronized (this) {
                if (!this.initialized) {
                    this.initialized = true;
                    this.hybridView = getViewOnce();
                }
            }
        }
        return this.hybridView;
    }

    /* loaded from: classes4.dex */
    public static final class WebViewLazy extends AbsHybridViewLazy {
        private final WebView webView;

        public WebViewLazy(WebView webView) {
            this.webView = webView;
        }

        @Override // com.bytedance.ies.web.jsbridge2.AbsHybridViewLazy
        protected View getViewOnce() {
            return this.webView;
        }
    }
}
