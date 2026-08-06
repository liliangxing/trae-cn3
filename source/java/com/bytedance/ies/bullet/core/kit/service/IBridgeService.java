package com.bytedance.ies.bullet.core.kit.service;

import com.bytedance.ies.bullet.core.kit.bridge.BridgeHandleUnit;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScopeProviderFactory;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBridgeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\tH&J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/service/IBridgeService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "createBridgeRegistryTransformerProvider", "Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistryTransformer;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createBridgeScopeProviders", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "createBridges", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod;", "createIDLBridges", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "createMethodFinder", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "defaultBridges2IDLXBridgeMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "defaultBridges", "defaultIDLBridges2IDLXBridgeMethod", "initialize", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBridgeService extends IBulletService {
    IProcessor<BridgeHandleUnit> createBridgeRegistryTransformerProvider(ContextProviderFactory providerFactory);

    List<IBridgeScopeProviderFactory> createBridgeScopeProviders(ContextProviderFactory providerFactory);

    List<IBridgeMethod> createBridges(ContextProviderFactory providerFactory);

    List<IGenericBridgeMethod> createIDLBridges(ContextProviderFactory providerFactory);

    List<MethodFinder> createMethodFinder(ContextProviderFactory providerFactory);

    List<IDLXBridgeMethod> defaultBridges2IDLXBridgeMethod(List<? extends IBridgeMethod> defaultBridges);

    List<IDLXBridgeMethod> defaultIDLBridges2IDLXBridgeMethod(List<? extends IGenericBridgeMethod> defaultBridges);

    void initialize();

    /* compiled from: IBridgeService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static IProcessor<BridgeHandleUnit> createBridgeRegistryTransformerProvider(IBridgeService iBridgeService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return null;
        }

        public static List<IBridgeScopeProviderFactory> createBridgeScopeProviders(IBridgeService iBridgeService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return CollectionsKt.emptyList();
        }

        public static List<IBridgeMethod> createBridges(IBridgeService iBridgeService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return new ArrayList();
        }

        public static List<IGenericBridgeMethod> createIDLBridges(IBridgeService iBridgeService, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
            return new ArrayList();
        }
    }
}
