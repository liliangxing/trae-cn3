package com.bytedance.ies.argus.aspect.eventCenter;

import android.webkit.WebView;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rJ\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0016H\u0016R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0016\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/WebViewContext;", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "Landroid/webkit/WebView;", "()V", "value", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "entryUrlInfo", "getEntryUrlInfo", "()Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "setEntryUrlInfo", "(Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;)V", "lastCheckHttpUrlInfo", "Lkotlin/Pair;", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "getLastCheckHttpUrlInfo", "()Lkotlin/Pair;", "setLastCheckHttpUrlInfo", "(Lkotlin/Pair;)V", "lastLoadHttpUrlInfo", "getLastLoadHttpUrlInfo", "setLastLoadHttpUrlInfo", "reloadUrl", "", "getReloadUrl", "()Ljava/lang/String;", "setReloadUrl", "(Ljava/lang/String;)V", "secLinkStrategy", "Lcom/bytedance/webx/seclink/base/ISecLinkStrategy;", "getSecLinkStrategy", "setSecLinkStrategy", "getMainPageInfo", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "recordUrlInfo", "", "urlParams", "verifyResult", "ttmGetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewContext extends BaseViewContext<WebView> {
    private WebLoadUrlParams entryUrlInfo;
    private Pair<WebLoadUrlParams, ? extends AspectVerifyResult<?>> lastCheckHttpUrlInfo;
    private WebLoadUrlParams lastLoadHttpUrlInfo;
    private String reloadUrl;
    private Pair<? extends ISecLinkStrategy, String> secLinkStrategy;

    public final Pair<WebLoadUrlParams, AspectVerifyResult<?>> getLastCheckHttpUrlInfo() {
        return this.lastCheckHttpUrlInfo;
    }

    public final void setLastCheckHttpUrlInfo(Pair<WebLoadUrlParams, ? extends AspectVerifyResult<?>> pair) {
        this.lastCheckHttpUrlInfo = pair;
    }

    public final WebLoadUrlParams getLastLoadHttpUrlInfo() {
        return this.lastLoadHttpUrlInfo;
    }

    public final void setLastLoadHttpUrlInfo(WebLoadUrlParams webLoadUrlParams) {
        this.lastLoadHttpUrlInfo = webLoadUrlParams;
    }

    public final WebLoadUrlParams getEntryUrlInfo() {
        return this.entryUrlInfo;
    }

    public final void setEntryUrlInfo(WebLoadUrlParams webLoadUrlParams) {
        if (this.entryUrlInfo != null || webLoadUrlParams == null) {
            return;
        }
        this.entryUrlInfo = webLoadUrlParams;
        webLoadUrlParams.setEntryUrl$anniex_release(true);
    }

    public final String getReloadUrl() {
        return this.reloadUrl;
    }

    public final void setReloadUrl(String str) {
        this.reloadUrl = str;
    }

    public final Pair<ISecLinkStrategy, String> getSecLinkStrategy() {
        return this.secLinkStrategy;
    }

    public final void setSecLinkStrategy(Pair<? extends ISecLinkStrategy, String> pair) {
        this.secLinkStrategy = pair;
    }

    public final void recordUrlInfo(WebLoadUrlParams urlParams, AspectVerifyResult<?> verifyResult) {
        Intrinsics.checkNotNullParameter(urlParams, "urlParams");
        if (this.entryUrlInfo == null) {
            setEntryUrlInfo(urlParams);
        }
        if (urlParams.getIsHttp()) {
            if (verifyResult == null) {
                this.lastLoadHttpUrlInfo = urlParams;
            } else {
                this.lastCheckHttpUrlInfo = new Pair<>(urlParams, verifyResult);
            }
        }
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public Object ttmGetValue(String key) {
        WebLoadUrlParams webLoadUrlParams;
        WebLoadUrlParams webLoadUrlParams2;
        WebLoadUrlParams webLoadUrlParams3;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        switch (key.hashCode()) {
            case -1575617922:
                if (key.equals("entry_url_is_inner") && (webLoadUrlParams = this.entryUrlInfo) != null) {
                    return Boolean.valueOf(webLoadUrlParams.isInnerHost$anniex_release());
                }
                return null;
            case -1534462114:
                if (key.equals("view_class")) {
                    return getViewClassName();
                }
                return null;
            case -1520009307:
                if (key.equals("entry_url_host") && (webLoadUrlParams2 = this.entryUrlInfo) != null) {
                    return webLoadUrlParams2.getHost();
                }
                return null;
            case -479038430:
                if (key.equals("entry_url") && (webLoadUrlParams3 = this.entryUrlInfo) != null) {
                    return webLoadUrlParams3.getLoadUrl();
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext
    public IFePageInfo getMainPageInfo() {
        return this.entryUrlInfo;
    }
}
