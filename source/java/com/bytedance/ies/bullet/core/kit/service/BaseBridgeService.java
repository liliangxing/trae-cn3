package com.bytedance.ies.bullet.core.kit.service;

import com.bytedance.ies.bullet.core.kit.bridge.BridgeHandleUnit;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScopeProviderFactory;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBridgeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/service/BaseBridgeService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/core/kit/service/IBridgeService;", "()V", "beforePageRender", "", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createBridgeRegistryTransformerProvider", "Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistryTransformer;", "createBridgeScopeProviders", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "createBridges", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod;", "createEndMethodFinder", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "createFirstFinder", "createIDLBridges", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "createMethodFinder", "createStatefulBridges", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "defaultBridges2IDLXBridgeMethod", "defaultBridges", "defaultIDLBridges2IDLXBridgeMethod", "initialize", "useJsb3", "", "usePiperData", "useWebXBridge3", "useXBridge3", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BaseBridgeService extends BaseBulletService implements IBridgeService {
    public void beforePageRender(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public IProcessor<BridgeHandleUnit> createBridgeRegistryTransformerProvider(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    public MethodFinder createEndMethodFinder(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    public MethodFinder createFirstFinder(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public void initialize() {
    }

    public boolean useJsb3() {
        return false;
    }

    public boolean usePiperData() {
        return false;
    }

    public boolean useWebXBridge3() {
        return false;
    }

    public boolean useXBridge3() {
        return false;
    }

    public List<MethodFinder> createMethodFinder(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<IBridgeScopeProviderFactory> createBridgeScopeProviders(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<IBridgeMethod> createBridges(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<IGenericBridgeMethod> createIDLBridges(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<IDLXBridgeMethod> defaultBridges2IDLXBridgeMethod(List<? extends IBridgeMethod> defaultBridges) {
        Intrinsics.checkNotNullParameter(defaultBridges, "defaultBridges");
        return new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<IDLXBridgeMethod> defaultIDLBridges2IDLXBridgeMethod(List<? extends IGenericBridgeMethod> defaultBridges) {
        Intrinsics.checkNotNullParameter(defaultBridges, "defaultBridges");
        return new ArrayList();
    }

    public List<IDLXBridgeMethod> createStatefulBridges(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return new ArrayList();
    }
}
