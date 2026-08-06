package com.bytedance.ies.bullet.web.pia;

import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.pia.core.api.plugin.IPiaLifeCycle;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaLifeCycle;", "", "innerLifeCycle", "Lcom/bytedance/pia/core/api/plugin/IPiaLifeCycle;", "(Lcom/bytedance/pia/core/api/plugin/IPiaLifeCycle;)V", "workerBridgeHandle", "Lcom/bytedance/ies/bullet/web/pia/PiaWorkerBridgeHandle;", "bindContext", "", "webView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "destroy", "evaluateJavascript", "script", "", "loadUrl", "url", "onPageFinished", "onPageStarted", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "shouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaLifeCycle {
    private final IPiaLifeCycle innerLifeCycle;
    private final PiaWorkerBridgeHandle workerBridgeHandle;

    public PiaLifeCycle(IPiaLifeCycle iPiaLifeCycle) {
        Intrinsics.checkNotNullParameter(iPiaLifeCycle, "innerLifeCycle");
        this.innerLifeCycle = iPiaLifeCycle;
        this.workerBridgeHandle = new PiaWorkerBridgeHandle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindContext(SSWebView webView, BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        this.workerBridgeHandle.bindContext(bulletContext);
        this.innerLifeCycle.onBindBridge(this.workerBridgeHandle);
        this.innerLifeCycle.onBindView((View) webView);
    }

    public final void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.innerLifeCycle.loadUrl(url);
        this.workerBridgeHandle.onLoadUrl(url);
    }

    public final void evaluateJavascript(String script) {
        if (script != null) {
            this.workerBridgeHandle.onEvaluateJavascript(script);
        }
    }

    public final void destroy() {
        this.innerLifeCycle.onDestroy();
    }

    public final void onPageStarted(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.innerLifeCycle.onLoadStart(url);
    }

    public final void onPageFinished(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.innerLifeCycle.onLoadFinish(url);
    }

    public final void shouldOverrideUrlLoading(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.innerLifeCycle.onRedirect(url);
    }

    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!this.innerLifeCycle.shouldHandleResource(request.getUrl())) {
            return null;
        }
        IResourceRequest resourceRequest = PiaHelper.INSTANCE.toResourceRequest(request);
        IResourceResponse onBeforeLoadResource = this.innerLifeCycle.onBeforeLoadResource(resourceRequest);
        if (onBeforeLoadResource != null) {
            return PiaHelper.INSTANCE.toWebResourceResponse(onBeforeLoadResource);
        }
        IResourceResponse onAfterLoadResource = this.innerLifeCycle.onAfterLoadResource(resourceRequest, null);
        if (onAfterLoadResource != null) {
            return PiaHelper.INSTANCE.toWebResourceResponse(onAfterLoadResource);
        }
        return null;
    }
}
