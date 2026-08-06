package com.bytedance.ies.bullet.service.base.web;

import android.content.Context;
import android.webkit.WebView;
import kotlin.Metadata;

/* compiled from: WebPreCreateServiceConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "", "()V", "preCreateWebViewWhenRegister", "", "getPreCreateWebViewWhenRegister", "()Z", "setPreCreateWebViewWhenRegister", "(Z)V", "size", "", "getSize", "()I", "setSize", "(I)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "webViewFactory", "Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig$IWebViewFactory;", "getWebViewFactory", "()Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig$IWebViewFactory;", "setWebViewFactory", "(Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig$IWebViewFactory;)V", "IWebViewFactory", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WebPreCreateServiceConfig {
    private boolean preCreateWebViewWhenRegister;
    private int size = 1;
    private String type;
    private IWebViewFactory webViewFactory;

    /* compiled from: WebPreCreateServiceConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig$IWebViewFactory;", "", "create", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IWebViewFactory {
        WebView create(Context context);
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final IWebViewFactory getWebViewFactory() {
        return this.webViewFactory;
    }

    public final void setWebViewFactory(IWebViewFactory iWebViewFactory) {
        this.webViewFactory = iWebViewFactory;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final boolean getPreCreateWebViewWhenRegister() {
        return this.preCreateWebViewWhenRegister;
    }

    public final void setPreCreateWebViewWhenRegister(boolean z) {
        this.preCreateWebViewWhenRegister = z;
    }
}
