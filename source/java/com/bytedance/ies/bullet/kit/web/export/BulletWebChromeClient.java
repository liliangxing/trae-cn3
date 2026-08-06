package com.bytedance.ies.bullet.kit.web.export;

import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import kotlin.Metadata;

/* compiled from: BulletWebChromeClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/export/BulletWebChromeClient;", "Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate;", "()V", "webKitView", "Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;", "getWebKitView", "()Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;", "setWebKitView", "(Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;)V", "setWebKitViewService", "", "webKitViewService", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BulletWebChromeClient extends WebChromeClientDelegate {
    private IWebKitViewService webKitView;

    public final IWebKitViewService getWebKitView() {
        return this.webKitView;
    }

    public final void setWebKitView(IWebKitViewService iWebKitViewService) {
        this.webKitView = iWebKitViewService;
    }

    public void setWebKitViewService(IWebKitViewService webKitViewService) {
        this.webKitView = webKitViewService;
    }
}
