package com.bytedance.ies.bullet.service.webkit;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.impl.util.WebViewUtils;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler;
import com.bytedance.ies.bullet.service.base.web.IWebPreCreateService;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDispatcher;
import com.bytedance.ies.bullet.service.base.web.WebViewDelegateConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u000b\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u001c\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\f\u0010$\u001a\u00020\u001d*\u00020\u0014H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/WebViewDelegate;", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "webKitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "config", "Lcom/bytedance/ies/bullet/service/base/web/WebViewDelegateConfig;", "(Lcom/bytedance/ies/bullet/service/webkit/WebKitService;Lcom/bytedance/ies/bullet/service/base/web/WebViewDelegateConfig;)V", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/web/WebViewDelegateConfig;", "globalPropsHandler", "Lcom/bytedance/ies/bullet/service/webkit/GlobalPropsHandler;", "getGlobalPropsHandler", "()Lcom/bytedance/ies/bullet/service/webkit/GlobalPropsHandler;", "globalPropsHandler$delegate", "Lkotlin/Lazy;", "webChromeClientDispatcher", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher;", "getWebKitService", "()Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "webView", "Landroid/webkit/WebView;", "webViewClientDispatcher", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDispatcher;", "createWebView", "context", "Landroid/content/Context;", "preCreateType", "", "destroy", "", "Lcom/bytedance/ies/bullet/service/base/web/IGlobalPropsHandler;", "getWebChromeClientDispatcher", "getWebView", "getWebViewClientDispatcher", "provideWebView", "setWebView", "setup", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebViewDelegate implements IWebViewDelegate {
    private final WebViewDelegateConfig config;

    /* renamed from: globalPropsHandler$delegate, reason: from kotlin metadata */
    private final Lazy globalPropsHandler;
    private final WebChromeClientDispatcher webChromeClientDispatcher;
    private final WebKitService webKitService;
    private WebView webView;
    private final WebViewClientDispatcher webViewClientDispatcher;

    public WebViewDelegate(WebKitService webKitService, WebViewDelegateConfig webViewDelegateConfig) {
        Intrinsics.checkNotNullParameter(webKitService, "webKitService");
        Intrinsics.checkNotNullParameter(webViewDelegateConfig, "config");
        this.webKitService = webKitService;
        this.config = webViewDelegateConfig;
        this.webViewClientDispatcher = new WebViewClientDispatcher();
        this.webChromeClientDispatcher = new WebChromeClientDispatcher();
        this.globalPropsHandler = LazyKt.lazy(new Function0<GlobalPropsHandler>() { // from class: com.bytedance.ies.bullet.service.webkit.WebViewDelegate$globalPropsHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final GlobalPropsHandler m590invoke() {
                return new GlobalPropsHandler(WebViewDelegate.this.getWebKitService());
            }
        });
    }

    public final WebViewDelegateConfig getConfig() {
        return this.config;
    }

    public final WebKitService getWebKitService() {
        return this.webKitService;
    }

    private final GlobalPropsHandler getGlobalPropsHandler() {
        return (GlobalPropsHandler) this.globalPropsHandler.getValue();
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public WebView provideWebView(Context context, String preCreateType) {
        WebView provideWebView;
        Intrinsics.checkNotNullParameter(context, "context");
        IWebPreCreateService iWebPreCreateService = (IWebPreCreateService) StandardServiceManager.INSTANCE.get(IWebPreCreateService.class);
        if (iWebPreCreateService == null || (provideWebView = iWebPreCreateService.provideWebView(context, preCreateType)) == null) {
            return null;
        }
        this.webView = provideWebView;
        setup(provideWebView);
        return provideWebView;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public IWebViewDelegate createWebView(Context context, String preCreateType) {
        Intrinsics.checkNotNullParameter(context, "context");
        IWebPreCreateService iWebPreCreateService = (IWebPreCreateService) StandardServiceManager.INSTANCE.get(IWebPreCreateService.class);
        WebView provideWebView = iWebPreCreateService != null ? iWebPreCreateService.provideWebView(context, preCreateType) : null;
        this.webView = provideWebView;
        if (provideWebView == null) {
            this.webView = (WebView) WebViewUtils.INSTANCE.createWebView(context);
        }
        WebView webView = this.webView;
        if (webView != null) {
            setup(webView);
        }
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public IWebViewDelegate setWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        setup(webView);
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public WebView getWebView() throws IllegalStateException {
        WebView webView = this.webView;
        if (webView != null) {
            return webView;
        }
        throw new IllegalStateException("You must call 'createWebView' or 'setWebView' first.".toString());
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public WebViewClientDispatcher getWebViewClientDispatcher() {
        return this.webViewClientDispatcher;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public WebChromeClientDispatcher getWebChromeClientDispatcher() {
        return this.webChromeClientDispatcher;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    /* renamed from: getGlobalPropsHandler, reason: collision with other method in class */
    public IGlobalPropsHandler mo589getGlobalPropsHandler() {
        return getGlobalPropsHandler();
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebViewDelegate
    public void destroy() {
        this.webViewClientDispatcher.clear();
        this.webChromeClientDispatcher.clear();
    }

    private final void setup(WebView webView) {
        webView.setWebViewClient(this.webViewClientDispatcher);
        webView.setWebChromeClient(this.webChromeClientDispatcher);
    }
}
