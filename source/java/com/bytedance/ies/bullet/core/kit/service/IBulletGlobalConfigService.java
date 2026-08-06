package com.bytedance.ies.bullet.core.kit.service;

import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletGlobalConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/service/IBulletGlobalConfigService;", "", "createKitViewLifecycleDelegate", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBulletGlobalConfigService {

    /* compiled from: IBulletGlobalConfigService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static IBulletLoadLifeCycle createKitViewLifecycleDelegate(IBulletGlobalConfigService iBulletGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }
    }

    IBulletLoadLifeCycle createKitViewLifecycleDelegate(ContextProviderFactory providerFactory);
}
