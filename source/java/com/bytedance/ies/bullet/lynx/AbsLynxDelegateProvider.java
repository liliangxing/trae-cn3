package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import kotlin.Metadata;

/* compiled from: AbsLynxDelegateProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegateProvider;", "Lcom/bytedance/ies/bullet/lynx/ILynxDelegateProvider;", "()V", "provideLynxDelegate", "Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "sessionId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsLynxDelegateProvider implements ILynxDelegateProvider {
    public abstract AbsLynxDelegate provideLynxDelegate(BaseBulletService service, IServiceToken context, String sessionId);
}
