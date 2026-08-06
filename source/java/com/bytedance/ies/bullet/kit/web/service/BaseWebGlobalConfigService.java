package com.bytedance.ies.bullet.kit.web.service;

import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.CustomWebSettings;
import com.bytedance.ies.bullet.kit.web.IJavascriptInterfaceDelegate;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebGlobalConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/service/BaseWebGlobalConfigService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;", "()V", "applySettings", "", ErrorType.SETTINGS, "Landroid/webkit/WebSettings;", "webView", "Landroid/webkit/WebView;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createCustomSettings", "Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;", "createJavascriptInterfaceDelegate", "Lcom/bytedance/ies/bullet/kit/web/IJavascriptInterfaceDelegate;", "createKitViewLifecycleDelegate", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "createWebChromeClientDelegate", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebChromeClient;", "createWebSecureDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "createWebViewClientDelegate", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebViewClient;", "createWebViewLoadUrlInterceptorDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "getExtraModelType", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getModelType", "provideWebJsBridgeConfig", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseWebGlobalConfigService extends BaseBulletService implements IWebGlobalConfigService {
    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public IJavascriptInterfaceDelegate createJavascriptInterfaceDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBulletGlobalConfigService
    public IBulletLoadLifeCycle createKitViewLifecycleDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public BulletWebChromeClient createWebChromeClientDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public IWebSecureDelegate createWebSecureDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public BulletWebViewClient createWebViewClientDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public IWebViewLoadUrlInterceptorDelegate createWebViewLoadUrlInterceptorDelegate(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public List<Class<? extends ISchemaModel>> getExtraModelType() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public IWebJsBridgeConfig provideWebJsBridgeConfig(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    @Deprecated(message = "no more use")
    public Map<String, Object> getAnniXConstants(String str, Uri uri) {
        return IWebGlobalConfigService.DefaultImpls.getAnniXConstants(this, str, uri);
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public Map<String, Object> getConstants(ContextProviderFactory contextProviderFactory) {
        return IWebGlobalConfigService.DefaultImpls.getConstants(this, contextProviderFactory);
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public void applySettings(WebSettings settings, WebView webView, ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(settings, ErrorType.SETTINGS);
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
    }

    @Override // com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService
    public CustomWebSettings createCustomSettings(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return new CustomWebSettings(true, null, 2, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.ICommonConfigService
    public Class<? extends ISchemaModel> getModelType() {
        return BDXWebKitModel.class;
    }
}
