package com.bytedance.ies.bullet.kit.web.service;

import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.kit.service.IBulletGlobalConfigService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.CustomWebSettings;
import com.bytedance.ies.bullet.kit.web.IJavascriptInterfaceDelegate;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.bullet.service.base.ICommonConfigService;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebGlobalConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;", "Lcom/bytedance/ies/bullet/service/base/ICommonConfigService;", "Lcom/bytedance/ies/bullet/core/kit/service/IBulletGlobalConfigService;", "applySettings", "", ErrorType.SETTINGS, "Landroid/webkit/WebSettings;", "webView", "Landroid/webkit/WebView;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createCustomSettings", "Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;", "createJavascriptInterfaceDelegate", "Lcom/bytedance/ies/bullet/kit/web/IJavascriptInterfaceDelegate;", "createWebChromeClientDelegate", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebChromeClient;", "createWebSecureDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "createWebViewClientDelegate", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebViewClient;", "createWebViewLoadUrlInterceptorDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "getAnniXConstants", "", "", "", "bid", "uri", "Landroid/net/Uri;", "provideWebJsBridgeConfig", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IWebGlobalConfigService extends ICommonConfigService, IBulletGlobalConfigService {
    void applySettings(WebSettings settings, WebView webView, ContextProviderFactory providerFactory);

    CustomWebSettings createCustomSettings(ContextProviderFactory providerFactory);

    IJavascriptInterfaceDelegate createJavascriptInterfaceDelegate(ContextProviderFactory providerFactory);

    BulletWebChromeClient createWebChromeClientDelegate(ContextProviderFactory providerFactory);

    IWebSecureDelegate createWebSecureDelegate(ContextProviderFactory providerFactory);

    BulletWebViewClient createWebViewClientDelegate(ContextProviderFactory providerFactory);

    IWebViewLoadUrlInterceptorDelegate createWebViewLoadUrlInterceptorDelegate(ContextProviderFactory providerFactory);

    @Deprecated(message = "no more use")
    Map<String, Object> getAnniXConstants(String bid, Uri uri);

    IWebJsBridgeConfig provideWebJsBridgeConfig(ContextProviderFactory providerFactory);

    /* compiled from: IWebGlobalConfigService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static void applySettings(IWebGlobalConfigService iWebGlobalConfigService, WebSettings webSettings, WebView webView, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(webSettings, ErrorType.SETTINGS);
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        }

        public static CustomWebSettings createCustomSettings(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static IJavascriptInterfaceDelegate createJavascriptInterfaceDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static BulletWebChromeClient createWebChromeClientDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static IWebSecureDelegate createWebSecureDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static BulletWebViewClient createWebViewClientDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static IWebViewLoadUrlInterceptorDelegate createWebViewLoadUrlInterceptorDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        @Deprecated(message = "no more use")
        public static Map<String, Object> getAnniXConstants(IWebGlobalConfigService iWebGlobalConfigService, String str, Uri uri) {
            Intrinsics.checkNotNullParameter(str, "bid");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return null;
        }

        public static IWebJsBridgeConfig provideWebJsBridgeConfig(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static IBulletLoadLifeCycle createKitViewLifecycleDelegate(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return IBulletGlobalConfigService.DefaultImpls.createKitViewLifecycleDelegate(iWebGlobalConfigService, contextProviderFactory);
        }

        public static Map<String, Object> getConstants(IWebGlobalConfigService iWebGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return ICommonConfigService.DefaultImpls.getConstants(iWebGlobalConfigService, contextProviderFactory);
        }
    }
}
