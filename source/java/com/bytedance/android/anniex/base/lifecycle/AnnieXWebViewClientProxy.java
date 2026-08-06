package com.bytedance.android.anniex.base.lifecycle;

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
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebViewClientProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J&\u0010\u001b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J.\u0010\u001b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010#\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010(\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J0\u0010+\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010.\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010/2\b\u0010\u001d\u001a\u0004\u0018\u000100H\u0016J\u001c\u00101\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u000103H\u0017J.\u00104\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u000107H\u0017J\"\u00108\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J&\u0010<\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010?\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001e\u0010B\u001a\u0004\u0018\u00010*2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0017J\u001e\u0010B\u001a\u0004\u0018\u00010*2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010C\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001c\u0010D\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0017J\u001c\u0010D\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/bytedance/android/anniex/base/lifecycle/AnnieXWebViewClientProxy;", "Landroid/webkit/WebViewClient;", "container", "Lcom/bytedance/android/anniex/container/AnnieXContainer;", "webViewClient", "(Lcom/bytedance/android/anniex/container/AnnieXContainer;Landroid/webkit/WebViewClient;)V", "doUpdateVisitedHistory", "", "view", "Landroid/webkit/WebView;", StreamTrafficObservable.STREAM_URL, "", "isReload", "", "onFormResubmission", "dontResend", "Landroid/os/Message;", "resend", "onLoadResource", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedClientCertRequest", "request", "Landroid/webkit/ClientCertRequest;", "onReceivedError", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedLoginRequest", "account", "args", "onReceivedSslError", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "onSafeBrowsingHit", "threatType", "callback", "Landroid/webkit/SafeBrowsingResponse;", "onScaleChanged", "oldScale", "", "newScale", "onTooManyRedirects", "cancelMsg", "continueMsg", "onUnhandledKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "shouldInterceptRequest", "shouldOverrideKeyEvent", "shouldOverrideUrlLoading", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebViewClientProxy extends WebViewClient {
    public static final String TAG = "AnnieXWebViewClient";
    private final AnnieXContainer container;
    private final WebViewClient webViewClient;

    public AnnieXWebViewClientProxy(AnnieXContainer annieXContainer, WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(annieXContainer, "container");
        this.container = annieXContainer;
        this.webViewClient = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.shouldOverrideUrlLoading(view, url);
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.shouldOverrideUrlLoading(view, request);
        }
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onPageStarted(view, url, favicon);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onPageFinished(view, url);
        }
        this.container.onWebPageFinish(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onLoadResource(view, url);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(view, url);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.shouldInterceptRequest(view, url);
        }
        return super.shouldInterceptRequest(view, url);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.shouldInterceptRequest(view, request);
        }
        return super.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        super.onTooManyRedirects(view, cancelMsg, continueMsg);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(view, cancelMsg, continueMsg);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(view, errorCode, description, failingUrl);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(view, request, error);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(view, request, errorResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        super.onFormResubmission(view, dontResend, resend);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(view, dontResend, resend);
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(view, url, isReload);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(view, handler, error);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        super.onReceivedClientCertRequest(view, request);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(view, request);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.shouldOverrideKeyEvent(view, event);
        }
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(view, event);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(view, oldScale, newScale);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(view, realm, account, args);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onRenderProcessGone(view, detail);
        }
        return super.onRenderProcessGone(view, detail);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient != null) {
            webViewClient.onSafeBrowsingHit(view, request, threatType, callback);
        }
        super.onSafeBrowsingHit(view, request, threatType, callback);
    }
}
