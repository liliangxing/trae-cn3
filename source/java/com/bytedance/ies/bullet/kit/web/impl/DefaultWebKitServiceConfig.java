package com.bytedance.ies.bullet.kit.web.impl;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.web.WebKitServiceConfig;
import com.bytedance.ies.bullet.service.base.web.WebPreCreateServiceConfig;
import com.bytedance.webx.WebX;
import com.bytedance.webx.core.webview.WebviewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultWebKitServiceConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/impl/DefaultWebKitServiceConfig;", "Lcom/bytedance/ies/bullet/service/base/web/WebKitServiceConfig;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultWebKitServiceConfig extends WebKitServiceConfig {
    public DefaultWebKitServiceConfig() {
        WebPreCreateServiceConfig webPreCreateServiceConfig = new WebPreCreateServiceConfig();
        webPreCreateServiceConfig.setWebViewFactory(new WebPreCreateServiceConfig.IWebViewFactory() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitServiceConfig$1$1
            @Override // com.bytedance.ies.bullet.service.base.web.WebPreCreateServiceConfig.IWebViewFactory
            public WebView create(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultWebKitServiceConfig precreate webview", null, null, 6, null);
                try {
                    Object createContainer = ((WebviewManager) WebX.getContainerManager("webx_webkit", WebviewManager.class)).createContainer(context, (Class<Object>) SSWebView.class);
                    Intrinsics.checkNotNullExpressionValue(createContainer, "{\n                      …va)\n                    }");
                    return (WebView) createContainer;
                } catch (Throwable unused) {
                    return new SSWebView(context, null, 0, 6, null);
                }
            }
        });
        setWebPreCreateServiceConfig(webPreCreateServiceConfig);
    }
}
