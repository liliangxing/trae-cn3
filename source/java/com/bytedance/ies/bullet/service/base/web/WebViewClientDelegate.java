package com.bytedance.ies.bullet.service.base.web;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import kotlin.Metadata;

/* compiled from: WebCompatDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J&\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u001c\u0010\u0018\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0018\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDelegate;", "Landroid/webkit/WebViewClient;", "()V", WebViewContainerClient.EVENT_onReceivedError, "", "view", "Landroid/webkit/WebView;", OauthTokenTriggerScene.REQUEST, "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceRequest;", "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceError;", WebViewContainerClient.EVENT_onReceivedHttpError, "errorResponse", "Landroid/webkit/WebResourceResponse;", WebViewContainerClient.EVENT_onRenderProcessGone, "", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "Lcom/bytedance/ies/bullet/service/base/web/IRenderProcessGoneDetail;", WebViewContainerClient.EVENT_shouldInterceptRequest, "url", "", WebViewContainerClient.EVENT_shouldOverrideUrlLoading, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class WebViewClientDelegate extends WebViewClient {
    public void onReceivedError(WebView view, IWebResourceRequest request, IWebResourceError error) {
    }

    public void onReceivedHttpError(WebView view, IWebResourceRequest request, WebResourceResponse errorResponse) {
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        onReceivedError(view, request != null ? WebCompatDelegateKt.transform(request) : null, error != null ? WebCompatDelegateKt.transform(error) : null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        onReceivedHttpError(view, request != null ? WebCompatDelegateKt.transform(request) : null, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return shouldOverrideUrlLoading(view, request != null ? WebCompatDelegateKt.transform(request) : null);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return shouldInterceptRequest(view, request != null ? WebCompatDelegateKt.transform(request) : null);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        return onRenderProcessGone(view, detail != null ? WebCompatDelegateKt.transform(detail) : null);
    }

    public boolean shouldOverrideUrlLoading(WebView view, IWebResourceRequest request) {
        throw new YieldError("An operation is not implemented");
    }

    public WebResourceResponse shouldInterceptRequest(WebView view, IWebResourceRequest request) {
        throw new YieldError("An operation is not implemented");
    }

    public boolean onRenderProcessGone(WebView view, IRenderProcessGoneDetail detail) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        throw new YieldError("An operation is not implemented");
    }
}
