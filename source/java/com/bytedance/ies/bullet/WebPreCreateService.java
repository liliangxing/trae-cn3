package com.bytedance.ies.bullet;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.web.WebPreCreateServiceConfig;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.webx.precreate.PreCreateWebViewManager;
import com.bytedance.webx.precreate.api.IMultiWebViewSupplier;
import com.bytedance.webx.precreate.api.IWebViewFactory;
import com.bytedance.webx.precreate.model.PreCreateInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebPreCreateService.kt */
@Deprecated(message = "废弃，请使用 x-optimize 中的 WebPreCreateService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/WebPreCreateService;", "", "()V", EventConstants.PARAM_SOURCE_INIT, "", "application", "Landroid/content/Context;", "config", "Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "provideWebView", "Landroid/webkit/WebView;", "context", "type", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebPreCreateService {
    public static final String DEFAULT_WEBVIEW_TYPE = "webx_bullet";

    public final void init(Context application, final WebPreCreateServiceConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getWebViewFactory() == null) {
            return;
        }
        IMultiWebViewSupplier init = PreCreateWebViewManager.INSTANCE.init(application);
        String type = config.getType();
        if (type == null) {
            type = "webx_bullet";
        }
        init.registerWebView(type, new PreCreateInfo.Builder().setWebViewFactory(new IWebViewFactory() { // from class: com.bytedance.ies.bullet.WebPreCreateService$init$1
            public final WebView create(Context context, boolean z) {
                WebPreCreateServiceConfig.IWebViewFactory webViewFactory = WebPreCreateServiceConfig.this.getWebViewFactory();
                if (webViewFactory == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return webViewFactory.create(context);
            }
        }).setSize(config.getSize()).preCreateWebViewWhenRegister(config.getPreCreateWebViewWhenRegister()).build());
    }

    public static /* synthetic */ WebView provideWebView$default(WebPreCreateService webPreCreateService, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return webPreCreateService.provideWebView(context, str);
    }

    public final WebView provideWebView(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreCreateWebViewManager preCreateWebViewManager = PreCreateWebViewManager.INSTANCE;
        if (type == null) {
            type = "webx_bullet";
        }
        return preCreateWebViewManager.get(context, type);
    }
}
