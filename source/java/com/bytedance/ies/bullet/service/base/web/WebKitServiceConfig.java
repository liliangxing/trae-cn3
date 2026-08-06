package com.bytedance.ies.bullet.service.base.web;

import com.bytedance.ies.bullet.service.base.IKitConfig;
import kotlin.Metadata;

/* compiled from: IWebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebKitServiceConfig;", "Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "()V", "webPreCreateServiceConfig", "Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "getWebPreCreateServiceConfig", "()Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "setWebPreCreateServiceConfig", "(Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class WebKitServiceConfig implements IKitConfig {
    private WebPreCreateServiceConfig webPreCreateServiceConfig;

    public final WebPreCreateServiceConfig getWebPreCreateServiceConfig() {
        return this.webPreCreateServiceConfig;
    }

    public final void setWebPreCreateServiceConfig(WebPreCreateServiceConfig webPreCreateServiceConfig) {
        this.webPreCreateServiceConfig = webPreCreateServiceConfig;
    }
}
