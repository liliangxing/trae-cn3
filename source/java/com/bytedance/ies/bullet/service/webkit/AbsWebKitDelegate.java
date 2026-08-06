package com.bytedance.ies.bullet.service.webkit;

import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.kit.web.WebKitViewInitParams;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsWebKitDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH&J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020#H\u0016J&\u0010/\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u00063"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "(Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;)V", "getService", "()Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "bulletContextIsInitialized", "", "createWebView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "sessionId", "", "delegateLoadUrl", "", "webView", "url", "additionalHttpHeaders", "", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "injectUrl", "isDelegateLoadResource", "isDelegateLoadUrl", "loadPiaResource", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "loadResource", "onLoadFail", "onLoadStart", "onLoadSuccess", "onPageStarted", "onWebViewCreate", "view", "Landroid/view/View;", "kitView", "Lcom/bytedance/ies/bullet/kit/web/WebKitView;", "parseSchema", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "provideEventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "provideWebKitInitParams", "Lcom/bytedance/ies/bullet/kit/web/WebKitViewInitParams;", "release", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "updateGlobalProps", "uri", "Landroid/net/Uri;", "globalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsWebKitDelegate {
    private final BaseBulletService service;

    public boolean bulletContextIsInitialized() {
        return true;
    }

    public abstract SSWebView createWebView(String sessionId);

    public void delegateLoadUrl(SSWebView webView, String url, Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    public abstract BulletContext getContext();

    public String injectUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return url;
    }

    public boolean isDelegateLoadResource(String url) {
        return false;
    }

    public boolean isDelegateLoadUrl(String url) {
        return false;
    }

    public WebResourceResponse loadPiaResource(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return null;
    }

    public WebResourceResponse loadResource(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return null;
    }

    public WebResourceResponse loadResource(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    public void onLoadFail() {
    }

    public void onLoadStart(String url, String sessionId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public void onLoadSuccess() {
    }

    public void onPageStarted() {
    }

    public void onWebViewCreate(View view, WebKitView kitView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(kitView, "kitView");
    }

    public abstract SchemaModelUnion parseSchema(String url, String sessionId);

    public IEventHandler provideEventHandler() {
        return null;
    }

    public abstract WebKitViewInitParams provideWebKitInitParams();

    public void release(IKitViewService kitViewService) {
        Intrinsics.checkNotNullParameter(kitViewService, "kitViewService");
    }

    public void updateGlobalProps(Uri uri, View view) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void updateGlobalProps(View view, Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
    }

    public AbsWebKitDelegate(BaseBulletService baseBulletService) {
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        this.service = baseBulletService;
    }

    public final BaseBulletService getService() {
        return this.service;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void delegateLoadUrl$default(AbsWebKitDelegate absWebKitDelegate, SSWebView sSWebView, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delegateLoadUrl");
        }
        if ((i & 4) != 0) {
            map = null;
        }
        absWebKitDelegate.delegateLoadUrl(sSWebView, str, map);
    }
}
