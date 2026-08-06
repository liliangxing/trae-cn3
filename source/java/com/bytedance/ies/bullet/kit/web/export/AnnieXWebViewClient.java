package com.bytedance.ies.bullet.kit.web.export;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J.\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0017J0\u0010\u001f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0016J0\u0010$\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J&\u0010'\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J.\u0010+\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J\"\u00100\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0016J&\u00104\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000fH\u0017J\u001c\u00107\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001c\u0010:\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/export/AnnieXWebViewClient;", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDelegate;", "webViewClient", "Landroid/webkit/WebViewClient;", "(Landroid/webkit/WebViewClient;)V", WebViewContainerClient.EVENT_doUpdateVisitedHistory, "", "view", "Landroid/webkit/WebView;", "url", "", "isReload", "", WebViewContainerClient.EVENT_onFormResubmission, "dontResend", "Landroid/os/Message;", "resend", WebViewContainerClient.EVENT_onLoadResource, WebViewContainerClient.EVENT_onPageCommitVisible, WebViewContainerClient.EVENT_onPageFinished, WebViewContainerClient.EVENT_onPageStarted, "favicon", "Landroid/graphics/Bitmap;", WebViewContainerClient.EVENT_onReceivedClientCertRequest, OauthTokenTriggerScene.REQUEST, "Landroid/webkit/ClientCertRequest;", WebViewContainerClient.EVENT_onReceivedError, "errorCode", "", "description", "failingUrl", WebViewContainerClient.EVENT_onReceivedHttpAuthRequest, "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", WebViewContainerClient.EVENT_onReceivedLoginRequest, SettingsTracker.TYPE_ACCOUNT, "args", WebViewContainerClient.EVENT_onReceivedSslError, "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", WebViewContainerClient.EVENT_onSafeBrowsingHit, "Landroid/webkit/WebResourceRequest;", "threatType", JsCallParser.VALUE_CALLBACK, "Landroid/webkit/SafeBrowsingResponse;", WebViewContainerClient.EVENT_onScaleChanged, "oldScale", "", "newScale", WebViewContainerClient.EVENT_onTooManyRedirects, "cancelMsg", "continueMsg", WebViewContainerClient.EVENT_onUnhandledKeyEvent, "event", "Landroid/view/KeyEvent;", WebViewContainerClient.EVENT_shouldOverrideKeyEvent, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnieXWebViewClient extends WebViewClientDelegate {
    private final WebViewClient webViewClient;

    public AnnieXWebViewClient(WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        this.webViewClient = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        this.webViewClient.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        this.webViewClient.onPageStarted(view, url, favicon);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        this.webViewClient.onPageFinished(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        this.webViewClient.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        this.webViewClient.onPageCommitVisible(view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        this.webViewClient.onTooManyRedirects(view, cancelMsg, continueMsg);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        this.webViewClient.onFormResubmission(view, dontResend, resend);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        this.webViewClient.doUpdateVisitedHistory(view, url, isReload);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        this.webViewClient.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        this.webViewClient.onReceivedClientCertRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        this.webViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return this.webViewClient.shouldOverrideKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        this.webViewClient.onUnhandledKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        this.webViewClient.onScaleChanged(view, oldScale, newScale);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        this.webViewClient.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
        this.webViewClient.onSafeBrowsingHit(view, request, threatType, callback);
    }
}
