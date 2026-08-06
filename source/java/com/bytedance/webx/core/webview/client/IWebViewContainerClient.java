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

/* loaded from: classes6.dex */
public interface IWebViewContainerClient {
    void doUpdateVisitedHistory(WebView webView, String str, boolean z);

    void onFormResubmission(WebView webView, Message message, Message message2);

    void onLoadResource(WebView webView, String str);

    void onPageCommitVisible(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest);

    @Deprecated
    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2);

    void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    void onReceivedLoginRequest(WebView webView, String str, String str2, String str3);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

    void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse);

    void onScaleChanged(WebView webView, float f, float f2);

    @Deprecated
    void onTooManyRedirects(WebView webView, Message message, Message message2);

    void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent);

    WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

    @Deprecated
    WebResourceResponse shouldInterceptRequest(WebView webView, String str);

    boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent);

    boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);

    @Deprecated
    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
