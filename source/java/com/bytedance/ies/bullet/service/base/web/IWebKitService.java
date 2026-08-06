package com.bytedance.ies.bullet.service.base.web;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.IKitService;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;

/* compiled from: IWebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IWebKitService;", "Lcom/bytedance/ies/bullet/service/base/IKitService;", "createKitViewWithSessionId", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "sessionId", "", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "createWebDelegate", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "config", "Lcom/bytedance/ies/bullet/service/base/web/WebViewDelegateConfig;", EventConstants.PARAM_SOURCE_INIT, "", "application", "Landroid/content/Context;", "Lcom/bytedance/ies/bullet/service/base/web/WebKitServiceConfig;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IWebKitService extends IKitService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEFAULT_WEBX_NAMESPACE = "webx_webkit";

    IKitViewService createKitViewWithSessionId(String sessionId, IServiceToken context);

    IWebViewDelegate createWebDelegate(WebViewDelegateConfig config);

    void init(Context application, WebKitServiceConfig config);

    /* compiled from: IWebKitService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IWebKitService$Companion;", "", "()V", "DEFAULT_WEBX_NAMESPACE", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEFAULT_WEBX_NAMESPACE = "webx_webkit";

        private Companion() {
        }
    }

    /* compiled from: IWebKitService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(IWebKitService iWebKitService, Context context, WebKitServiceConfig webKitServiceConfig, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
            }
            if ((i & 2) != 0) {
                webKitServiceConfig = null;
            }
            iWebKitService.init(context, webKitServiceConfig);
        }
    }
}
