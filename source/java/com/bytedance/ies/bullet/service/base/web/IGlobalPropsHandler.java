package com.bytedance.ies.bullet.service.base.web;

import android.webkit.WebView;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IWebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IGlobalPropsHandler;", "", "injectContextProvider", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "injectGlobalProps", "webView", "Landroid/webkit/WebView;", "updateGlobalProps", "globalProps", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IGlobalPropsHandler {
    void injectContextProvider(ContextProviderFactory contextProviderFactory);

    void injectGlobalProps(WebView webView);

    void updateGlobalProps(Map<String, ? extends Object> globalProps);
}
