package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.base.web.IWebPreCreateService;
import com.bytedance.ies.bullet.service.base.web.WebPreCreateServiceConfig;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.webx.precreate.PreCreateWebViewManager;
import com.bytedance.webx.precreate.api.IMultiWebViewSupplier;
import com.bytedance.webx.precreate.api.IWebViewFactory;
import com.bytedance.webx.precreate.model.PreCreateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebPreCreateService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WebPreCreateService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/web/IWebPreCreateService;", "()V", EventConstants.PARAM_SOURCE_INIT, "", "application", "Landroid/content/Context;", "config", "Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "preCreateWebView", "context", "provideWebView", "Landroid/webkit/WebView;", "type", "", "submitPreCreateWebView", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebPreCreateService extends BaseBulletService implements IWebPreCreateService {
    public static final String DEFAULT_WEBVIEW_TYPE = "webx_bullet";

    @Override // com.bytedance.ies.bullet.service.base.web.IWebPreCreateService
    public void init(Context application, final WebPreCreateServiceConfig config) {
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
        init.registerWebView(type, new PreCreateInfo.Builder().setWebViewFactory(new IWebViewFactory() { // from class: com.bytedance.ies.bullet.service.preload.WebPreCreateService$init$1
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

    @Override // com.bytedance.ies.bullet.service.base.web.IWebPreCreateService
    public void submitPreCreateWebView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IWebKitService iWebKitService = (IWebKitService) getService(IWebKitService.class);
        if (iWebKitService != null) {
            IWebKitService.DefaultImpls.init$default(iWebKitService, context, null, 2, null);
        }
        PreCreateWebViewManager.INSTANCE.resize("webx_bullet", 1);
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebPreCreateService
    public void preCreateWebView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IWebKitService iWebKitService = (IWebKitService) getService(IWebKitService.class);
        if (iWebKitService != null) {
            IWebKitService.DefaultImpls.init$default(iWebKitService, context, null, 2, null);
        }
        PreCreateWebViewManager.INSTANCE.preCreate("webx_bullet");
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebPreCreateService
    public WebView provideWebView(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        IWebKitService iWebKitService = (IWebKitService) getService(IWebKitService.class);
        if (iWebKitService != null) {
            IWebKitService.DefaultImpls.init$default(iWebKitService, context, null, 2, null);
        }
        PreCreateWebViewManager preCreateWebViewManager = PreCreateWebViewManager.INSTANCE;
        if (type == null) {
            type = "webx_bullet";
        }
        return preCreateWebViewManager.get(context, type);
    }
}
