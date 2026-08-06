package com.bytedance.android.anniex.web.api;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig;
import com.bytedance.ies.bullet.kit.web.impl.AnnieXWebController;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.webkit.IWebKitDelegateProvider;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J+\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/web/api/AnnieXWebApi;", "", "()V", "createWebView", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "context", "Landroid/content/Context;", "bid", "", "getWebViewUA", "onlyByCache", "", "getWebViewUA$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebApi {
    public static final AnnieXWebApi INSTANCE = new AnnieXWebApi();

    private AnnieXWebApi() {
    }

    public static /* synthetic */ AnnieXWebKit createWebView$default(AnnieXWebApi annieXWebApi, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        return annieXWebApi.createWebView(context, str);
    }

    public final AnnieXWebKit createWebView(Context context, String bid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        BulletSdk.INSTANCE.ensureDefaultBidReady(context);
        if (IConditionCallKt.enableLitePageBidExpand()) {
            WebKitService webKitService = ServiceCenter.Companion.instance().get(bid, IWebKitService.class);
            WebKitService webKitService2 = webKitService instanceof WebKitService ? webKitService : null;
            if (webKitService2 != null) {
                AnnieXWebKit annieXWebKit = new AnnieXWebKit(bid, webKitService2);
                annieXWebKit.createWebView(context);
                return annieXWebKit;
            }
        }
        AnnieXWebKit annieXWebKit2 = new AnnieXWebKit(bid, null, 2, null);
        annieXWebKit2.createWebView(context);
        return annieXWebKit2;
    }

    public static /* synthetic */ String getWebViewUA$anniex_release$default(AnnieXWebApi annieXWebApi, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = "default_bid";
        }
        return annieXWebApi.getWebViewUA$anniex_release(context, z, str);
    }

    public final String getWebViewUA$anniex_release(Context context, boolean onlyByCache, String bid) {
        WebView createWebView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        WebEngineGlobalConfig webEngineGlobalConfig = new WebEngineGlobalConfig();
        BulletContext bulletContext = new BulletContext();
        bulletContext.setSimpleCard(true);
        bulletContext.setBid(bid);
        webEngineGlobalConfig.config(bulletContext, CollectionsKt.emptyList());
        if (onlyByCache) {
            createWebView = IWebViewDelegate.DefaultImpls.provideWebView$default(new AnnieXWebController(new WebKitService((IKitConfig) null, (IWebKitDelegateProvider) null, 3, (DefaultConstructorMarker) null)).getWebViewDelegate(), context, (String) null, 2, (Object) null);
        } else {
            createWebView = new AnnieXWebController(new WebKitService((IKitConfig) null, (IWebKitDelegateProvider) null, 3, (DefaultConstructorMarker) null)).createWebView(context);
        }
        if (createWebView == null) {
            return null;
        }
        IWebGlobalConfigService defaultGlobalWebConfigService = webEngineGlobalConfig.getDefaultGlobalWebConfigService();
        if (defaultGlobalWebConfigService != null) {
            WebSettings settings = createWebView.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
            ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
            contextProviderFactory.registerHolder(Context.class, context);
            Unit unit = Unit.INSTANCE;
            defaultGlobalWebConfigService.applySettings(settings, createWebView, contextProviderFactory);
        }
        for (IWebGlobalConfigService iWebGlobalConfigService : CollectionsKt.reversed(webEngineGlobalConfig.getWebGlobalConfigServiceList())) {
            WebSettings settings2 = createWebView.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings2, "webView.settings");
            ContextProviderFactory contextProviderFactory2 = new ContextProviderFactory();
            contextProviderFactory2.registerHolder(Context.class, context);
            Unit unit2 = Unit.INSTANCE;
            iWebGlobalConfigService.applySettings(settings2, createWebView, contextProviderFactory2);
        }
        return createWebView.getSettings().getUserAgentString();
    }
}
