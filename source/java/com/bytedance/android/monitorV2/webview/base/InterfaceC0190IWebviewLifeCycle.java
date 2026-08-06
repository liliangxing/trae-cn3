package com.bytedance.android.monitorV2.webview.base;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.FetchError;

/* renamed from: com.bytedance.android.monitorV2.webview.base.IWebviewLifeCycle, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC0190IWebviewLifeCycle {
    void destroy(WebView webView);

    void goBack(WebView webView);

    void handleFetchError(WebView webView, FetchError fetchError);

    void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

    void handleRequestError(WebView webView, int i, String str, String str2);

    void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    void handleRequestHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    void handleViewCreate(WebView webView);

    @Deprecated
    void onAttachedToWindow(WebView webView);

    void onLoadUrl(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str);

    @Deprecated
    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i);

    void reload(WebView webView);
}
