package com.bytedance.ies.bullet.kit.lynx.service;

import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.kit.service.IBulletGlobalConfigService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.ICommonConfigService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILynxGlobalConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/kit/lynx/service/ILynxGlobalConfigService;", "Lcom/bytedance/ies/bullet/service/base/ICommonConfigService;", "Lcom/bytedance/ies/bullet/core/kit/service/IBulletGlobalConfigService;", "createBehaviors", "", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createGlobalClientDelegate", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "createLynxModule", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILynxGlobalConfigService extends ICommonConfigService, IBulletGlobalConfigService {
    List<?> createBehaviors(ContextProviderFactory providerFactory);

    ILynxClientDelegate createGlobalClientDelegate(ContextProviderFactory providerFactory);

    List<?> createLynxModule(ContextProviderFactory providerFactory);

    /* compiled from: ILynxGlobalConfigService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static List<?> createBehaviors(ILynxGlobalConfigService iLynxGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static ILynxClientDelegate createGlobalClientDelegate(ILynxGlobalConfigService iLynxGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static List<?> createLynxModule(ILynxGlobalConfigService iLynxGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static IBulletLoadLifeCycle createKitViewLifecycleDelegate(ILynxGlobalConfigService iLynxGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return IBulletGlobalConfigService.DefaultImpls.createKitViewLifecycleDelegate(iLynxGlobalConfigService, contextProviderFactory);
        }

        public static Map<String, Object> getConstants(ILynxGlobalConfigService iLynxGlobalConfigService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return ICommonConfigService.DefaultImpls.getConstants(iLynxGlobalConfigService, contextProviderFactory);
        }
    }
}
