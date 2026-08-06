package com.bytedance.ies.bullet.kit.web;

import com.bytedance.ies.bullet.base.depend.INetworkDepend;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import kotlin.Metadata;

/* compiled from: WebKitViewInitParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebKitViewInitParams;", "", "()V", "enableSafeWebJSBAuth", "", "getEnableSafeWebJSBAuth", "()Z", "setEnableSafeWebJSBAuth", "(Z)V", "isCachedView", "setCachedView", "networkDepend", "Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "getNetworkDepend", "()Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "setNetworkDepend", "(Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;)V", "sccConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "getSccConfig", "()Lcom/bytedance/ies/bullet/secure/SccConfig;", "setSccConfig", "(Lcom/bytedance/ies/bullet/secure/SccConfig;)V", "uiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getUiModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "setUiModel", "(Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;)V", "urlInterceptorDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "getUrlInterceptorDelegate", "()Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "setUrlInterceptorDelegate", "(Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;)V", "webViewDelegate", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "getWebViewDelegate", "()Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "setWebViewDelegate", "(Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;)V", "webkitModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;", "getWebkitModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;", "setWebkitModel", "(Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebKitViewInitParams {
    private boolean enableSafeWebJSBAuth;
    private boolean isCachedView;
    private INetworkDepend networkDepend;
    private SccConfig sccConfig;
    private BDXPageModel uiModel;
    private IWebViewLoadUrlInterceptorDelegate urlInterceptorDelegate;
    private IWebViewDelegate webViewDelegate;
    private BDXWebKitModel webkitModel;

    public final INetworkDepend getNetworkDepend() {
        return this.networkDepend;
    }

    public final void setNetworkDepend(INetworkDepend iNetworkDepend) {
        this.networkDepend = iNetworkDepend;
    }

    public final SccConfig getSccConfig() {
        return this.sccConfig;
    }

    public final void setSccConfig(SccConfig sccConfig) {
        this.sccConfig = sccConfig;
    }

    public final IWebViewLoadUrlInterceptorDelegate getUrlInterceptorDelegate() {
        return this.urlInterceptorDelegate;
    }

    public final void setUrlInterceptorDelegate(IWebViewLoadUrlInterceptorDelegate iWebViewLoadUrlInterceptorDelegate) {
        this.urlInterceptorDelegate = iWebViewLoadUrlInterceptorDelegate;
    }

    public final BDXPageModel getUiModel() {
        return this.uiModel;
    }

    public final void setUiModel(BDXPageModel bDXPageModel) {
        this.uiModel = bDXPageModel;
    }

    public final BDXWebKitModel getWebkitModel() {
        return this.webkitModel;
    }

    public final void setWebkitModel(BDXWebKitModel bDXWebKitModel) {
        this.webkitModel = bDXWebKitModel;
    }

    public final IWebViewDelegate getWebViewDelegate() {
        return this.webViewDelegate;
    }

    public final void setWebViewDelegate(IWebViewDelegate iWebViewDelegate) {
        this.webViewDelegate = iWebViewDelegate;
    }

    /* renamed from: isCachedView, reason: from getter */
    public final boolean getIsCachedView() {
        return this.isCachedView;
    }

    public final void setCachedView(boolean z) {
        this.isCachedView = z;
    }

    public final boolean getEnableSafeWebJSBAuth() {
        return this.enableSafeWebJSBAuth;
    }

    public final void setEnableSafeWebJSBAuth(boolean z) {
        this.enableSafeWebJSBAuth = z;
    }
}
