package com.bytedance.webx.core.webview.client;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.webx.core.ThreadSession;
import com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.event.EventManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebViewContainerClient extends WebViewContainerClientInner {
    public static final String EVENT_doUpdateVisitedHistory = "doUpdateVisitedHistory";
    public static final String EVENT_onFormResubmission = "onFormResubmission";
    public static final String EVENT_onLoadResource = "onLoadResource";
    public static final String EVENT_onPageCommitVisible = "onPageCommitVisible";
    public static final String EVENT_onPageFinished = "onPageFinished";
    public static final String EVENT_onPageStarted = "onPageStarted";
    public static final String EVENT_onReceivedClientCertRequest = "onReceivedClientCertRequest";
    public static final String EVENT_onReceivedError = "onReceivedError";
    public static final String EVENT_onReceivedHttpAuthRequest = "onReceivedHttpAuthRequest";
    public static final String EVENT_onReceivedHttpError = "onReceivedHttpError";
    public static final String EVENT_onReceivedLoginRequest = "onReceivedLoginRequest";
    public static final String EVENT_onReceivedSslError = "onReceivedSslError";
    public static final String EVENT_onRenderProcessGone = "onRenderProcessGone";
    public static final String EVENT_onSafeBrowsingHit = "onSafeBrowsingHit";
    public static final String EVENT_onScaleChanged = "onScaleChanged";
    public static final String EVENT_onTooManyRedirects = "onTooManyRedirects";
    public static final String EVENT_onUnhandledKeyEvent = "onUnhandledKeyEvent";
    public static final String EVENT_shouldInterceptRequest = "shouldInterceptRequest";
    public static final String EVENT_shouldOverrideKeyEvent = "shouldOverrideKeyEvent";
    public static final String EVENT_shouldOverrideUrlLoading = "shouldOverrideUrlLoading";

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_shouldOverrideUrlLoading);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean shouldOverrideUrlLoading = ((ListenerStub) topListener).shouldOverrideUrlLoading(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return shouldOverrideUrlLoading;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_shouldOverrideUrlLoading);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean shouldOverrideUrlLoading = ((ListenerStub) topListener).shouldOverrideUrlLoading(webView, webResourceRequest);
            ThreadSession.sExtensionExtendStack.get().pop();
            return shouldOverrideUrlLoading;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPageStarted);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPageStarted(webView, str, bitmap);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onPageFinished(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPageFinished);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPageFinished(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPageFinished(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onLoadResource(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onLoadResource);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onLoadResource(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onLoadResource(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onPageCommitVisible(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onPageCommitVisible);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onPageCommitVisible(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onPageCommitVisible(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_shouldInterceptRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebResourceResponse shouldInterceptRequest = ((ListenerStub) topListener).shouldInterceptRequest(webView, str);
            ThreadSession.sExtensionExtendStack.get().pop();
            return shouldInterceptRequest;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse __super_shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_shouldInterceptRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebResourceResponse shouldInterceptRequest = ((ListenerStub) topListener).shouldInterceptRequest(webView, webResourceRequest);
            ThreadSession.sExtensionExtendStack.get().pop();
            return shouldInterceptRequest;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse __super_shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onTooManyRedirects);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onTooManyRedirects(webView, message, message2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onTooManyRedirects(webView, message, message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedError);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedError(webView, i, str, str2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedError(webView, i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedError);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedError(webView, webResourceRequest, webResourceError);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedHttpError);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onFormResubmission);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onFormResubmission(webView, message, message2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onFormResubmission(webView, message, message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_doUpdateVisitedHistory);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).doUpdateVisitedHistory(webView, str, z);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.doUpdateVisitedHistory(webView, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedSslError);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedSslError(webView, sslErrorHandler, sslError);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedClientCertRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedClientCertRequest(webView, clientCertRequest);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedHttpAuthRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_shouldOverrideKeyEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean shouldOverrideKeyEvent = ((ListenerStub) topListener).shouldOverrideKeyEvent(webView, keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return shouldOverrideKeyEvent;
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onUnhandledKeyEvent);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onUnhandledKeyEvent(webView, keyEvent);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onScaleChanged);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onScaleChanged(webView, f, f2);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onScaleChanged(webView, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onScaleChanged(WebView webView, float f, float f2) {
        super.onScaleChanged(webView, f, f2);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onReceivedLoginRequest);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onReceivedLoginRequest(webView, str, str2, str3);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onRenderProcessGone);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            boolean onRenderProcessGone = ((ListenerStub) topListener).onRenderProcessGone(webView, renderProcessGoneDetail);
            ThreadSession.sExtensionExtendStack.get().pop();
            return onRenderProcessGone;
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean __super_onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // com.bytedance.webx.core.webview.client.inner.WebViewContainerClientInner, android.webkit.WebViewClient, com.bytedance.webx.core.webview.client.IWebViewContainerClient
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_onSafeBrowsingHit);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            ((ListenerStub) topListener).onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            ThreadSession.sExtensionExtendStack.get().pop();
            return;
        }
        super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __super_onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class ListenerStub extends AbsListenerStub<WebViewContainerClient> implements IWebViewContainerClient {
        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_shouldOverrideUrlLoading);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_shouldOverrideUrlLoading(webView, str);
            }
            return ((ListenerStub) findNextListener).shouldOverrideUrlLoading(webView, str);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_shouldOverrideUrlLoading);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return ((ListenerStub) findNextListener).shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onPageStarted);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPageStarted(webView, str, bitmap);
            } else {
                ((ListenerStub) findNextListener).onPageStarted(webView, str, bitmap);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onPageFinished(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onPageFinished);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPageFinished(webView, str);
            } else {
                ((ListenerStub) findNextListener).onPageFinished(webView, str);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onLoadResource(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onLoadResource);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onLoadResource(webView, str);
            } else {
                ((ListenerStub) findNextListener).onLoadResource(webView, str);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onPageCommitVisible(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onPageCommitVisible);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onPageCommitVisible(webView, str);
            } else {
                ((ListenerStub) findNextListener).onPageCommitVisible(webView, str);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_shouldInterceptRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_shouldInterceptRequest(webView, str);
            }
            return ((ListenerStub) findNextListener).shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_shouldInterceptRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_shouldInterceptRequest(webView, webResourceRequest);
            }
            return ((ListenerStub) findNextListener).shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onTooManyRedirects);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onTooManyRedirects(webView, message, message2);
            } else {
                ((ListenerStub) findNextListener).onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedError);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedError(webView, i, str, str2);
            } else {
                ((ListenerStub) findNextListener).onReceivedError(webView, i, str, str2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedError);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                ((ListenerStub) findNextListener).onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedHttpError);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                ((ListenerStub) findNextListener).onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onFormResubmission);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onFormResubmission(webView, message, message2);
            } else {
                ((ListenerStub) findNextListener).onFormResubmission(webView, message, message2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_doUpdateVisitedHistory);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_doUpdateVisitedHistory(webView, str, z);
            } else {
                ((ListenerStub) findNextListener).doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedSslError);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                ((ListenerStub) findNextListener).onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedClientCertRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                ((ListenerStub) findNextListener).onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedHttpAuthRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                ((ListenerStub) findNextListener).onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_shouldOverrideKeyEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_shouldOverrideKeyEvent(webView, keyEvent);
            }
            return ((ListenerStub) findNextListener).shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onUnhandledKeyEvent);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onUnhandledKeyEvent(webView, keyEvent);
            } else {
                ((ListenerStub) findNextListener).onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onScaleChanged);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onScaleChanged(webView, f, f2);
            } else {
                ((ListenerStub) findNextListener).onScaleChanged(webView, f, f2);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onReceivedLoginRequest);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                ((ListenerStub) findNextListener).onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onRenderProcessGone);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return ((ListenerStub) findNextListener).onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // com.bytedance.webx.core.webview.client.IWebViewContainerClient
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebViewContainerClient.EVENT_onSafeBrowsingHit);
            if (!(findNextListener instanceof ListenerStub)) {
                getExtendable().__super_onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            } else {
                ((ListenerStub) findNextListener).onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            }
        }
    }
}
