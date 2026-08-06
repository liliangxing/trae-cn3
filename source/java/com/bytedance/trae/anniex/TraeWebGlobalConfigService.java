package com.bytedance.trae.anniex;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate;
import com.bytedance.ies.bullet.kit.web.service.BaseWebGlobalConfigService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeWebGlobalConfigService.kt */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\r\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;", "Lcom/bytedance/ies/bullet/kit/web/service/BaseWebGlobalConfigService;", "<init>", "()V", "applySettings", "", "settings", "Landroid/webkit/WebSettings;", "webView", "Landroid/webkit/WebView;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "urlInterceptorDelegate", "com/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1", "Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;", "createWebViewLoadUrlInterceptorDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeWebGlobalConfigService extends BaseWebGlobalConfigService {
    public static final int $stable = 0;
    private final TraeWebGlobalConfigService$urlInterceptorDelegate$1 urlInterceptorDelegate = new TraeWebGlobalConfigService$urlInterceptorDelegate$1();

    public void applySettings(WebSettings settings, WebView webView, ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        super.applySettings(settings, webView, providerFactory);
        settings.setUserAgentString(" trae/0.0.1");
    }

    public IWebViewLoadUrlInterceptorDelegate createWebViewLoadUrlInterceptorDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return this.urlInterceptorDelegate;
    }
}
