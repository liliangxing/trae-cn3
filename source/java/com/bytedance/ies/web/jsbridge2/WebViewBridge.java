package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebViewBridge extends AbstractBridge {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean debug;
    private boolean isShowDebugToast;
    private String jsObjectName;
    private ISafeWebView safeWebViewImpl;
    private WebView webView;

    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    protected Context getContext(Environment environment) {
        if (environment.context != null) {
            return environment.context;
        }
        if (environment.webView != null) {
            return environment.webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    public String getUrl() {
        WebView webView = this.webView;
        if (webView instanceof ISafeWebView) {
            String safeUrl = ((ISafeWebView) webView).getSafeUrl();
            return TextUtils.isEmpty(safeUrl) ? this.webView.getUrl() : safeUrl;
        }
        ISafeWebView iSafeWebView = this.safeWebViewImpl;
        if (iSafeWebView != null) {
            String safeUrl2 = iSafeWebView.getSafeUrl();
            return TextUtils.isEmpty(safeUrl2) ? this.webView.getUrl() : safeUrl2;
        }
        Environment.checkWebView(this.debug, this.isShowDebugToast, webView);
        return this.webView.getUrl();
    }

    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    protected void init(Environment environment) {
        this.debug = environment.debug;
        this.isShowDebugToast = environment.isShowDebugToast;
        this.webView = environment.webView;
        this.jsObjectName = environment.jsObjectName;
        if (!environment.dummy) {
            this.webView.addJavascriptInterface(this, this.jsObjectName);
        }
        this.safeWebViewImpl = environment.safeWebViewImpl;
    }

    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    public void release() {
        super.release();
        this.webView.removeJavascriptInterface(this.jsObjectName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    public void invokeJsCallback(String str, Js2JavaCall js2JavaCall) {
        if (js2JavaCall != null && !TextUtils.isEmpty(js2JavaCall.iFrameUrl)) {
            String str2 = js2JavaCall.iFrameUrl;
            invokeCallback(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.invokeJsCallback(str, js2JavaCall);
    }

    @Override // com.bytedance.ies.web.jsbridge2.AbstractBridge
    protected void invokeJs(String str) {
        invokeCallback(str, "javascript:" + this.jsObjectName + "._handleMessageFromToutiao(" + str + ")");
    }

    private void invokeCallback(String str, final String str2) {
        if (this.released || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.WebViewBridge.1
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewBridge.this.released) {
                    return;
                }
                DebugUtil.m65i("Invoking Jsb using evaluateJavascript: " + str2);
                WebViewBridge.this.webView.evaluateJavascript(str2, null);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            DebugUtil.m65i("Received call on sub-thread, posting to main thread: " + str2);
            this.mainHandler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
