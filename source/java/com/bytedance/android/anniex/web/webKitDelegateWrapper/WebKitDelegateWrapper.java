package com.bytedance.android.anniex.web.webKitDelegateWrapper;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebKitDelegateWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J7\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\u001aJ\u0017\u0010\u001b\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/web/webKitDelegateWrapper/WebKitDelegateWrapper;", "", "webViewModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "kitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "(Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "delegate", "Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "getDelegate", "()Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "delegateLoadUrl", "", "webView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", StreamTrafficObservable.STREAM_URL, "", "additionalHttpHeaders", "", "delegateLoadUrl$anniex_release", "isDelegateLoadResource", "", "isDelegateLoadResource$anniex_release", "isDelegateLoadUrl", "isDelegateLoadUrl$anniex_release", "loadResource", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "loadResource$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WebKitDelegateWrapper {
    private final ContextProviderFactory contextProviderFactory;
    private final AbsWebKitDelegate delegate;

    public WebKitDelegateWrapper(AnnieXWebModel annieXWebModel, WebKitService webKitService) {
        ISchemaData schemaData;
        Uri originUrl;
        Intrinsics.checkNotNullParameter(annieXWebModel, "webViewModel");
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
        this.contextProviderFactory = contextProviderFactory;
        DefaultWebKitDelegate provideDelegate = webKitService.provideDelegate(annieXWebModel);
        this.delegate = provideDelegate;
        Intrinsics.checkNotNull(provideDelegate, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate");
        DefaultWebKitDelegate defaultWebKitDelegate = provideDelegate;
        defaultWebKitDelegate.setBulletContext(annieXWebModel.getBulletContext());
        defaultWebKitDelegate.getBulletContext().getMonitorCallback().onBulletContextCreated(defaultWebKitDelegate.getBulletContext());
        SchemaModelUnion schemaModelUnion = annieXWebModel.getSchemaModelUnion();
        contextProviderFactory.registerHolder(AnnieXWebModelSchema.class, (schemaModelUnion == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (originUrl = schemaData.getOriginUrl()) == null) ? null : new AnnieXWebModelSchema(originUrl));
        provideDelegate.setProviderFactory(contextProviderFactory);
    }

    public final AbsWebKitDelegate getDelegate() {
        return this.delegate;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final boolean isDelegateLoadUrl$anniex_release(String url) {
        return this.delegate.isDelegateLoadUrl(url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void delegateLoadUrl$anniex_release$default(WebKitDelegateWrapper webKitDelegateWrapper, SSWebView sSWebView, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        webKitDelegateWrapper.delegateLoadUrl$anniex_release(sSWebView, str, map);
    }

    public final void delegateLoadUrl$anniex_release(SSWebView webView, String url, Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.delegate.delegateLoadUrl(webView, url, additionalHttpHeaders);
    }

    public final boolean isDelegateLoadResource$anniex_release(String url) {
        return this.delegate.isDelegateLoadResource(url);
    }

    public final WebResourceResponse loadResource$anniex_release(String url) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        return this.delegate.loadResource(url);
    }

    public final WebResourceResponse loadResource$anniex_release(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.delegate.loadResource(request);
    }
}
