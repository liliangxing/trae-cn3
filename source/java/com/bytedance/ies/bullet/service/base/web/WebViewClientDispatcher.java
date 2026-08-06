package com.bytedance.ies.bullet.service.base.web;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: WebViewClientDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\fJ\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0015\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0017J\u001c\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0017\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J.\u0010\u001a\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J0\u0010\"\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010'\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J&\u0010*\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010+2\b\u0010\u001d\u001a\u0004\u0018\u00010,H\u0016J\u001c\u0010-\u001a\u00020.2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0017J\u001e\u00101\u001a\u0004\u0018\u00010)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\u001e\u00101\u001a\u0004\u0018\u00010)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00102\u001a\u00020.2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\u001c\u00102\u001a\u00020.2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u00063"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDispatcher;", "Landroid/webkit/WebViewClient;", "()V", "urlSet", "", "", "webViewClientDelegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDelegate;", "getWebViewClientDelegates", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addWebViewClient", "", "webViewClient", "index", "", "clear", "onLoadResource", "view", "Landroid/webkit/WebView;", "url", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onRenderProcessGone", "", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldInterceptRequest", "shouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebViewClientDispatcher extends WebViewClient {
    private final Set<String> urlSet = new LinkedHashSet();
    private final CopyOnWriteArrayList<WebViewClientDelegate> webViewClientDelegates = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<WebViewClientDelegate> getWebViewClientDelegates() {
        return this.webViewClientDelegates;
    }

    public final void addWebViewClient(WebViewClientDelegate webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        this.webViewClientDelegates.add(webViewClient);
    }

    public final void addWebViewClient(int index, WebViewClientDelegate webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        this.webViewClientDelegates.add(index, webViewClient);
    }

    public final void clear() {
        this.webViewClientDelegates.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r0.contains(r1 != null ? r1 : "") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
    
        com.bytedance.ies.bullet.service.base.BulletLogger.printLog$default(com.bytedance.ies.bullet.service.base.BulletLogger.INSTANCE, "WebViewClientDispatcher:onPageFinished but already finish,url=" + r10, null, "XWebKit", 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r8.urlSet.contains(r10) != false) goto L28;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageFinished(WebView view, String url) {
        String url2;
        BulletSettings provideBulletSettings;
        super.onPageFinished(view, url);
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        StringBuilder append = new StringBuilder("WebViewClientDispatcher:onPageFinished,url=").append(url).append(",WebViewUrl=");
        String url3 = view != null ? view.getUrl() : null;
        if (url3 == null) {
            url3 = "";
        }
        BulletLogger.printLog$default(bulletLogger, append.append(url3).toString(), null, "XWebKit", 2, null);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if ((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? true : provideBulletSettings.getEnableFinishOnce()) {
            if ((view != null ? view.getUrl() : null) != null) {
                Set<String> set = this.urlSet;
                String url4 = view.getUrl();
            }
            if (url != null) {
            }
        }
        if (view != null && (url2 = view.getUrl()) != null) {
            this.urlSet.add(url2);
        }
        if (url != null) {
            this.urlSet.add(url);
        }
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onPageFinished(view, url);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onReceivedError(view, errorCode, description, failingUrl);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onReceivedError(view, request, error);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onReceivedHttpError(view, request, errorResponse);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onReceivedHttpAuthRequest(view, handler, host, realm);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onReceivedSslError(view, handler, error);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        StringBuilder append = new StringBuilder("WebViewClientDispatcher:onPageStarted,url=").append(url).append(",WebViewUrl=");
        String url2 = view != null ? view.getUrl() : null;
        if (url2 == null) {
            url2 = "";
        }
        BulletLogger.printLog$default(bulletLogger, append.append(url2).toString(), null, "XWebKit", 2, null);
        Set<String> set = this.urlSet;
        if (set == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        TypeIntrinsics.asMutableCollection(set).remove(url);
        Set<String> set2 = this.urlSet;
        String url3 = view != null ? view.getUrl() : null;
        if (set2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        TypeIntrinsics.asMutableCollection(set2).remove(url3);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onPageStarted(view, url, favicon);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebViewClientDelegate) it.next()).shouldOverrideUrlLoading(view, url);
            } catch (YieldError unused) {
            }
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebViewClientDelegate) it.next()).shouldOverrideUrlLoading(view, request);
            } catch (YieldError unused) {
            }
        }
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebViewClientDelegate) it.next()).shouldInterceptRequest(view, url);
            } catch (YieldError unused) {
            }
        }
        return super.shouldInterceptRequest(view, url);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebViewClientDelegate) it.next()).shouldInterceptRequest(view, request);
            } catch (YieldError unused) {
            }
        }
        return super.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onLoadResource(view, url);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                return ((WebViewClientDelegate) it.next()).onRenderProcessGone(view, detail);
            } catch (YieldError unused) {
            }
        }
        return super.onRenderProcessGone(view, detail);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
        Iterator<T> it = this.webViewClientDelegates.iterator();
        while (it.hasNext()) {
            try {
                ((WebViewClientDelegate) it.next()).onPageCommitVisible(view, url);
            } catch (YieldError unused) {
            }
        }
    }
}
