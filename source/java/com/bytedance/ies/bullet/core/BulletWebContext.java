package com.bytedance.ies.bullet.core;

import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.container.api.ILongClickListenerProvider;
import com.bytedance.ies.bullet.core.container.IActionModeProvider;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletWebContext;", "", "()V", "actionModeProvider", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "getActionModeProvider", "()Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "setActionModeProvider", "(Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;)V", "enablePia", "", "getEnablePia", "()Z", "setEnablePia", "(Z)V", "longClickListenerProvider", "Lcom/bytedance/ies/bullet/container/api/ILongClickListenerProvider;", "getLongClickListenerProvider", "()Lcom/bytedance/ies/bullet/container/api/ILongClickListenerProvider;", "setLongClickListenerProvider", "(Lcom/bytedance/ies/bullet/container/api/ILongClickListenerProvider;)V", "webGlobalConfig", "Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "getWebGlobalConfig", "()Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "setWebGlobalConfig", "(Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;)V", "webViewClient", "Landroid/webkit/WebViewClient;", WebViewContainer.EVENT_getWebViewClient, "()Landroid/webkit/WebViewClient;", WebViewContainer.EVENT_setWebViewClient, "(Landroid/webkit/WebViewClient;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BulletWebContext {
    private IActionModeProvider actionModeProvider;
    private boolean enablePia;
    private ILongClickListenerProvider longClickListenerProvider;
    private IEngineGlobalConfig webGlobalConfig;
    private WebViewClient webViewClient;

    public final boolean getEnablePia() {
        return this.enablePia;
    }

    public final void setEnablePia(boolean z) {
        this.enablePia = z;
    }

    public final IEngineGlobalConfig getWebGlobalConfig() {
        return this.webGlobalConfig;
    }

    public final void setWebGlobalConfig(IEngineGlobalConfig iEngineGlobalConfig) {
        this.webGlobalConfig = iEngineGlobalConfig;
    }

    public final IActionModeProvider getActionModeProvider() {
        return this.actionModeProvider;
    }

    public final void setActionModeProvider(IActionModeProvider iActionModeProvider) {
        this.actionModeProvider = iActionModeProvider;
    }

    public final ILongClickListenerProvider getLongClickListenerProvider() {
        return this.longClickListenerProvider;
    }

    public final void setLongClickListenerProvider(ILongClickListenerProvider iLongClickListenerProvider) {
        this.longClickListenerProvider = iLongClickListenerProvider;
    }

    public final WebViewClient getWebViewClient() {
        return this.webViewClient;
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
    }
}
