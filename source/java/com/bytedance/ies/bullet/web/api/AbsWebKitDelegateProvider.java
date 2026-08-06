package com.bytedance.ies.bullet.web.api;

import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate;
import com.bytedance.ies.bullet.service.webkit.IWebKitDelegateProvider;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import kotlin.Metadata;

/* compiled from: AbsWebKitDelegateProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/web/api/AbsWebKitDelegateProvider;", "Lcom/bytedance/ies/bullet/service/webkit/IWebKitDelegateProvider;", "()V", "provideWebKitDelegate", "Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "service", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "sessionId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsWebKitDelegateProvider implements IWebKitDelegateProvider {
    public abstract AbsWebKitDelegate provideWebKitDelegate(WebKitService service, IServiceToken context, String sessionId);
}
