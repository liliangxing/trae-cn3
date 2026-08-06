package com.bytedance.ies.web.jsbridge;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
public class IESWebViewClient extends WebViewClient {
    private IESJsBridge mJsBridge;

    public IESWebViewClient() {
    }

    public IESWebViewClient(IESJsBridge iESJsBridge) {
        this.mJsBridge = iESJsBridge;
    }

    public IESJsBridge getJsBridge() {
        return this.mJsBridge;
    }

    public void setJsBridge(IESJsBridge iESJsBridge) {
        this.mJsBridge = iESJsBridge;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        IESJsBridge iESJsBridge = this.mJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.checkBridgeSchema(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IESJsBridge iESJsBridge = this.mJsBridge;
        return iESJsBridge != null && iESJsBridge.invokeJavaMethod(str);
    }
}
